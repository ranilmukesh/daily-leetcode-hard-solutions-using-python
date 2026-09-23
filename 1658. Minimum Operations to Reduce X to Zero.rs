impl Solution {
        pub fn min_operations(nums: Vec<i32>, x: i32) -> i32 {
                let target = nums.iter().sum::<i32>() - x;
                        if target < 0 {
                                    return -1;
                                            }
                                                    let mut left = 0usize;
                                                            let mut sum = 0i32;
                                                                    let mut best = if target == 0 { 0 } else { -1 };
                                                                            for right in 0..nums.len() {
                                                                                        sum += nums[right];
                                                                                                    while left <= right && sum > target {
                                                                                                                    sum -= nums[left];
                                                                                                                                    left += 1;
                                                                                                                                                }
                                                                                                                                                            if sum == target {
                                                                                                                                                                            best = best.max((right - left + 1) as i32);
                                                                                                                                                                                        }
                                                                                                                                                                                                }
                                                                                                                                                                                                        if best < 0 { -1 } else { nums.len() as i32 - best }
                                                                                                                                                                                                            }
}
