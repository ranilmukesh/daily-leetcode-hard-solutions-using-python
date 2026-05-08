use std::collections::{HashMap, VecDeque};
use std::sync::LazyLock;

const MAX_N: usize = 1_000_001;

static SMALLEST_PRIME_FACTOR: LazyLock<Vec<i32>> = LazyLock::new(|| {
    let mut spf = vec![0; MAX_N];

    for i in 2..MAX_N {
        if spf[i] != 0 {
            continue;
        }

        spf[i] = i as i32;

        if i * i >= MAX_N {
            continue;
        }

        for j in ((i * i)..MAX_N).step_by(i) {
            if spf[j] == 0 {
                spf[j] = i as i32;
            }
        }
    }

    spf
});

impl Solution {
    fn for_each_prime_factor(mut value: i32, mut f: impl FnMut(i32)) {
        while value != 1 {
            let prime_factor = SMALLEST_PRIME_FACTOR[value as usize];
            f(prime_factor);

            while value % prime_factor == 0 {
                value /= prime_factor;
            }
        }
    }

    pub fn min_jumps(nums: Vec<i32>) -> i32 {
        let n = nums.len();

        let mut prime_indices = HashMap::with_capacity(n);

        for (i, &a) in nums.iter().enumerate() {
            if SMALLEST_PRIME_FACTOR[a as usize] == a {
                prime_indices.entry(a).or_insert_with(Vec::new).push(i);
            }
        }

        let mut answer = 0;
        let mut visited = vec![false; n];
        visited[n - 1] = true;

        let mut q = VecDeque::new();
        q.push_back(n - 1);

        while !q.is_empty() {
            let layer_size = q.len();

            for _ in 0..layer_size {
                let node = q.pop_front().unwrap();

                if node == 0 {
                    return answer;
                }

                if node > 0 && !visited[node - 1] {
                    visited[node - 1] = true;
                    q.push_back(node - 1);
                }

                if node < n - 1 && !visited[node + 1] {
                    visited[node + 1] = true;
                    q.push_back(node + 1);
                }

                Self::for_each_prime_factor(nums[node], |prime| {
                    let Some(indices) = prime_indices.get_mut(&prime) else { return };

                    for target in indices.drain(..) {
                        if !visited[target] {
                            visited[target] = true;
                            q.push_back(target);
                        }
                    }
                });
            }

            answer += 1;
        }

        -1
    }
}
