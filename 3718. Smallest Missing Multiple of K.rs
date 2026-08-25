use std::collections::HashSet;

impl Solution {
    pub fn missing_multiple(nums: Vec<i32>, k: i32) -> i32 {
        let xs: HashSet<i32> = nums.into_iter().collect();
        
        let mut i = 1;
        let mut x = 0;
        while x <= 100 {
            x = i * k;
            if !xs.contains(&x) {
                return x;
            }
            i += 1;
        }

        x
    }
}
