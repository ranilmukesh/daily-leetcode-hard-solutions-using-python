impl Solution {
    pub fn missing_integer(nums: Vec<i32>) -> i32 {
        let mut prefix_sum: i32 = nums[0];
        for i in 1..nums.len() {
            if (nums[i] == (nums[i-1] + 1)) {
                prefix_sum += nums[i];
            } else {
                break;
            }
        }
        let mut ans: i32 = prefix_sum;
        while (nums.contains(&ans)) {
            ans += 1;
        }
        ans
    }
}
