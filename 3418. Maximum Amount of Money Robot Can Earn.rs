impl Solution {
    pub fn maximum_amount(coins: Vec<Vec<i32>>) -> i32 {
        let n = coins[0].len();
        let mut dp = vec![[i32::MIN / 2; 3]; n + 1];
        
        dp[1] = [0, 0, 0];
        for row in coins {
            for j in 1..= n {
                let x = row[j - 1];
                dp[j][2] = *[dp[j - 1][2] + x, dp[j][2] + x, dp[j - 1][1], dp[j][1]]
                    .iter().max().unwrap();
                dp[j][1] = *[dp[j - 1][1] + x, dp[j][1] + x, dp[j - 1][0], dp[j][0]]
                    .iter().max().unwrap();
                dp[j][0] = dp[j - 1][0].max(dp[j][0]) + x;
            }
        }
        
        dp[n][2]
    }
}
