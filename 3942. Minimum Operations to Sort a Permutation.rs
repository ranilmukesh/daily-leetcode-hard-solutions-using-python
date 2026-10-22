impl Solution {


    
    pub fn min_operations(nums: Vec<i32>) -> i32 {
        let len = nums.len();
        
        if len == 0 || len == 1 {
            return 0;
        } 
        
        if let Some(zero_index) = Self::analyze_increasing(&nums, true) {
            let double_flip = 2 + (nums.len() - zero_index) as i32;
            let rotate_left_cost = zero_index as i32;
            double_flip.min(rotate_left_cost)
        } else if let Some(zero_index) = Self::analyze_increasing(&nums, false) {
            println!("{}", zero_index);
            let option1 = 2 + zero_index as i32;
            let option2 = (nums.len() - zero_index) as i32;
            option1.min(option2)
        } else {
            -1
        }
    }

   

    fn analyze_increasing(nums : &[i32], ascending : bool) -> Option<usize> {
        let mut zero_index : i32 = if ascending { 0 } else {(nums.len() - 1) as i32};
        let mut is_monotone = true;
        
        for i in (0..nums.len() - 1) {
            let breaking_condition = if ascending {
                nums[i as usize] + 1 != nums[i+1 as usize]
            } else {
                nums[i as usize] != nums[i+1 as usize] + 1
            };
                
            if breaking_condition {
                if ascending && nums[i+1 as usize] == 0 {
                    zero_index = i as i32 + 1;
                } else if !ascending && nums[i as usize] == 0 {
                    zero_index = i as i32;
                } else {
                    is_monotone = false;
                    break;
                }
            }
        }
        
        if is_monotone  {
            Some(zero_index as usize)
        } else {
            None
        }
    }
}
