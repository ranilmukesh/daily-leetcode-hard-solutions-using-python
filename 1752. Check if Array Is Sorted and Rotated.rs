impl Solution {
    pub fn check(nums: Vec<i32>) -> bool {
        let mut c = 0;
        for i in 1..nums.len() {
            if nums[i-1] > nums[i] {
                c+=1;
            }
            if c > 1 {
                return false
            }
        }
        if nums[0] < nums[nums.len()-1] {
            c+=1;
        }
        c<=1
    }
}
