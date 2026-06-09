use std::cmp;

impl Solution {
    pub fn max_total_value(nums: Vec<i32>, k: i32) -> i64 {
        (*nums.iter().max().unwrap_or(&0) as i64 - *nums.iter().min().unwrap_or(&0) as i64) * k as i64
    }
}
