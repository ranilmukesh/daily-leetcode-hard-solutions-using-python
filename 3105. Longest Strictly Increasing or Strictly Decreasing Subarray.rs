use std::cmp::Ordering;

impl Solution {
    pub fn longest_monotonic_subarray(nums: Vec<i32>) -> i32 {
        let (mut prev, mut trend, mut count, mut result) = (*nums.first().unwrap(), 0, 0, 0);

        for &num in nums.iter().skip(1) {
            match num.cmp(&prev) {
                Ordering::Greater => {
                    if trend == 1 {
                        count += 1;
                    } else {
                        trend = 1;
                        count = 1;
                    }
                }
                Ordering::Less => {
                    if trend == -1 {
                        count += 1;
                    } else {
                        trend = -1;
                        count = 1;
                    }
                }
                Ordering::Equal => {
                    trend = 0;
                    count = 0;
                }
            }
            result = result.max(count);
            prev = num;
        }
        result + 1
    }
}
