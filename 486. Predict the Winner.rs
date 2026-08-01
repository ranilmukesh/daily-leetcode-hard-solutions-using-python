use std::cmp;

impl Solution {
    pub fn predict_the_winner(nums: Vec<i32>) -> bool {
        let n = nums.len();
        let mut dp = vec![0; n+1];
        for k in 0..n {
            for i in 0..n-k {
                dp[i] = cmp::max(nums[i] - dp[i+1], nums[i+k] - dp[i])
            }
        }
        return dp[0] >= 0;
    }
}
