impl Solution {
    pub fn result_array(nums: Vec<i32>, k: i32) -> Vec<i64> {
        let k = k as usize;
        let mut dp = vec![vec![0i64; k]; 2];
        let mut ans = vec![0i64; k];

        for x in nums {
            let x = x as usize % k;
            dp[1].fill(0);
            dp[1][x] = 1;
            ans[x] += 1;
            for r in 0..k {
                dp[1][r * x % k] += dp[0][r];
                ans[r * x % k] += dp[0][r];
            }
            dp.swap(0,1);
        }
        ans
    }
}
