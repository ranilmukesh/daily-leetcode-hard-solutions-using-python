impl Solution {
    pub fn path_existence_queries(n: i32, nums: Vec<i32>, max_diff: i32, queries: Vec<Vec<i32>>) -> Vec<bool> {
        let mut dp = Vec::with_capacity(n as usize);
        for i in 0..n as usize {
            dp.push(i);
            if i >=1 && (nums[i] - nums[i-1]).abs() <= max_diff {
                dp[i] = dp[i-1];
            }
        }
        let mut ret = Vec::with_capacity(queries.len());
        for q in queries {
            let mut f = q[0] as usize;
            let mut t = q[1] as usize;
            if (f > t) {
                let temp = f;
                f = t;
                t = temp;
            }
            if dp[t] <= f {
                ret.push(true);
            } else {
                ret.push(false);
            }   
        }
        ret
    }
}
