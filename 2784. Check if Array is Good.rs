impl Solution {
    pub fn is_good(mut nums: Vec<i32>) -> bool {
        let length : usize = nums.len();
        let mut counter : i32 = 0;
        nums.sort();
    
        if length != (nums[length-1] + 1) as usize {
            return false;
        }
        if nums[length-1] != nums[length-2] {
            return false;
        }

        for i in 0..length-2 {
            if nums[i] ^ nums[i+1] == 0 {
                return false;
            }
        }

        return true;
    }
}
