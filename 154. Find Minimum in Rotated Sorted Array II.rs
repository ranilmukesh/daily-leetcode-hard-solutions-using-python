use std::cmp;

impl Solution {
    pub fn find_min(mut nums: Vec<i32>) -> i32 {
        let mut left : usize = 0;
        let mut right : usize = nums.len()-1;

        while nums[left] == nums[right] && left != right {
            nums.remove(right);
            right -= 1;
        }
        
        if nums[left] < nums[right] {
            return nums[0];
        }

        let mut pointer : usize =  (right-left)/2;

        loop {
            if nums[pointer] < nums[left] {
                right = pointer;
                pointer = left + (right-left)/2;
            } else {
                left = pointer;
                pointer = left + (right-left)/2;
            }

            if right-left <= 1 {
                return cmp::min(nums[left], nums[right]);
            }
        }
    }
}
