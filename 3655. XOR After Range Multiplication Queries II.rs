impl Solution {
    fn cus_pow(mut base: i64, mut exp: i64, mod_:i64) -> i64 {
        let mut res:i64 = 1;
        while exp > 0 {
            if exp & 1 == 1 {
                res = res * base % mod_;
            }
            base = base * base % mod_;
            exp >>= 1;
        }
        return res;
    }
    pub fn xor_after_queries(nums: Vec<i32>, queries: Vec<Vec<i32>>) -> i32 {
        let mod_:i64 = 1000000007;
        let mut nums:Vec<i64> = nums.into_iter().map(|x| x as i64).collect();
        let mut ans = 0;
        let n = nums.len();
        let border: usize = (n as f64).sqrt() as usize;
        let mut data:Vec<i64> = vec!(1; n + border + 1);
        let mut small_q:Vec<Vec<(usize, usize, i64)>> = vec!(vec!(); border + 1);

        for q in queries {
            let (s, e, step, mult) = (q[0] as usize, q[1] as usize, q[2] as usize, q[3] as i64);
            if mult == 1 {continue;}
            if step > border {
                for i in (s..=e).step_by(step) {
                    nums[i] = nums[i] * mult % mod_;
                }
            } else {
                small_q[step].push((s, e, mult));
            }
        }

        for step in 1..=border {
            if small_q[step].is_empty() {continue;}
            let mut used:Vec<bool> = vec!(true; step);
            for (s, e, mult) in small_q[step]
                    .iter()
                    .map(|(a, b, c)| (*a, *b, *c)) {
                used[s % step] = false;
                let del_v = Self::cus_pow(mult, 1000000005, mod_);
                let count = (e - s) / step;
                let off_ind = s + (count + 1) * step;
                data[s] = data[s] * mult % mod_;
                data[off_ind] = data[off_ind] *del_v % mod_;
            }
            for start in 0..step {
                if used[start] {continue;}
                let mut curr_mult:i64 = 1;
                for i in (start..n).step_by(step) {
                    if data[i] != 1 { 
                        curr_mult = curr_mult * data[i] % mod_;
                        data[i] = 1; 
                    }
                    if curr_mult != 1 { nums[i] = nums[i] * curr_mult % mod_; }
                }
            }
        }

        for v in nums {
            ans ^= v;
        }
        return ans as i32;
    }
}
