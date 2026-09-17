impl Solution {
    pub fn min_sum_of_lengths(arr: Vec<i32>, target: i32) -> i32 {
        let mut dp = vec![i32::MAX; arr.len() + 1];
        let mut ans = i32::MAX;
        let mut acc = 0;
        let mut i = 0;
        for j in 0..arr.len() {
            acc += arr[j];
            while acc > target {
                acc -= arr[i];
                i += 1;
            }
            if acc == target {
                let len = (j - i + 1) as i32;
                if i > 0 {
                    ans = dp[i - 1].saturating_add(len).min(ans);
                }
                dp[j] = dp[j].min(len);
            }
            dp[j + 1] = dp[j];
        }
        if ans == i32::MAX { -1 } else { ans }
    }
}
