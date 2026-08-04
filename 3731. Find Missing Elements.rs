impl Solution {
    pub fn find_missing_elements(mut nums: Vec<i32>) -> Vec<i32> {
        nums.sort_unstable();
        let mut ans = Vec::new();
        for i in 0..nums.len() - 1 {
            for x in nums[i] + 1..nums[i + 1] {
                ans.push(x);
            }
        }
        ans
    }
}
