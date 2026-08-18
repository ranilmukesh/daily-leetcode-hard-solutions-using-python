use std::cmp::max;

impl Solution {
    pub fn largest_integer(nums: Vec<i32>, k: i32) -> i32 {
        let k = k as usize;
        let n = nums.len();

        let mut freq = [0; 51];
        for i in 0..n {
            freq[nums[i] as usize] += 1;
        }


        if k == 1 {
            for i in (0..freq.len()).rev() {
                if freq[i] == 1 {
                    return i as i32;
                }

            }
        } else if k == n {
            let mx = *nums.iter().max().expect("max");
            return mx;

        } else if 1 < k && k < n {
            let l = nums[0];
            let r = nums[n - 1];

            let fl = freq[l as usize];
            let fr = freq[r as usize];

            if fl > 1 && fr > 1 {
                return -1;
            }
            if fl == 1 && fr == 1 {
                let mx = max(l, r);
                return mx;
            }

            if fl > 1 {
                return r;
            }
            if fr > 1 {
                return l;
            }

        }

        -1
    }
}
