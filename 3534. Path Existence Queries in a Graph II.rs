impl Solution {
    pub fn path_existence_queries(
        _n: i32,
        nums: Vec<i32>,
        max_diff: i32,
        queries: Vec<Vec<i32>>,
    ) -> Vec<i32> {
        let mut unique_nums = nums.clone();
        unique_nums.sort_unstable();
        unique_nums.dedup();

        let mut nums_map = vec![usize::MAX; (*unique_nums.last().unwrap() + 1) as usize];

        let n = unique_nums.len();
        let logn = n.ilog2() as usize;
        let mut sparse = vec![vec![usize::MAX; n]; logn + 1];

        for (i, &num) in unique_nums.iter().enumerate() {
            nums_map[num as usize] = i;

            let idx = unique_nums.partition_point(|&x| x <= num + max_diff);

            if idx > i + 1 {
                sparse[0][i] = idx - 1;
            }
        }

        for j in 0..logn {
            for i in 0..n {
                let mid = sparse[j][i];
                if mid != usize::MAX {
                    sparse[j + 1][i] = sparse[j][mid];
                }
            }
        }

        let mut result = Vec::with_capacity(queries.len());

        for query in queries {
            if query[0] == query[1] {
                result.push(0);
                continue;
            }

            let (a, b) = (nums[query[0] as usize], nums[query[1] as usize]);
            let (a, b) = (nums_map[a as usize], nums_map[b as usize]);
            let (a, b) = (a.min(b), a.max(b));

            let target = unique_nums[b] - max_diff;

            if unique_nums[a] >= target {
                result.push(1);
                continue;
            }

            let mut cur = a;
            let mut distance = 2;

            for p in (0..=logn).rev() {
                let next = sparse[p][cur];

                if next != usize::MAX && unique_nums[next] < target {
                    cur = next;
                    distance += 1 << p;
                }
            }

            if sparse[0][cur] != usize::MAX && unique_nums[sparse[0][cur]] >= target {
                result.push(distance);
            } else {
                result.push(-1);
            }
        }

        result
    }
}
