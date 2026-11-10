impl Solution {
    pub fn climb_stairs(n: i32, costs: Vec<i32>) -> i32 {
        let n = n as usize;
        let mut dp = vec![0; n+1];

        for i in 1..=n {
            dp[i] = costs[i-1] + dp[i-1] + 1;
            if i > 1 {
                dp[i] = dp[i].min(costs[i-1] + dp[i-2]+4);
            }
            if i > 2 {
                dp[i] = dp[i].min(costs[i-1] + dp[i-3]+9);
            }
        }

        dp[n]
    }
}
