impl Solution {
    pub fn find_min(nums: Vec<i32>) -> i32 {
        let mut left = 0;
        let mut right = nums.len() - 1;

        while right > left {
            if nums[left] < nums[right] {
                break;
            } else {
                let midishpoint = left + (right-left)/2;
                if midishpoint == left {
                    return nums[left].min(nums[right]);
                }
                if nums[left] < nums[midishpoint] {
                    left = midishpoint + 1;
                } else {
                    right = midishpoint;
                }
            }
        }
        nums[left]
    }
}
