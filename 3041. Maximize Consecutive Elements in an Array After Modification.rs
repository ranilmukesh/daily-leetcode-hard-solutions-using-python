impl Solution {
    pub fn max_selected_elements(mut nums: Vec<i32>) -> i32 {
        nums.sort_unstable();
        let mut i = 0;
        while i < nums.len() && nums[i] == nums[0] {
            i += 1;
        }
        let mut dp = if i == 1 { (1, 1) } else { (1, 2) };
        let mut result = dp.1;
        while i < nums.len() {
            let mut j = i;
            while j < nums.len() && nums[j] == nums[i] {
                j += 1;
            }

            dp = if j == i + 1 {
                if nums[i] == nums[i - 1] + 1 {
                    (dp.0 + 1, dp.1 + 1)
                } else if nums[i] == nums[i - 1] + 2 {
                    (dp.1 + 1, 1)
                } else {
                    (1, 1)
                }
            } else {
                if nums[i] == nums[i - 1] + 1 {
                    (dp.0 + 1, (dp.0 + 2).max(dp.1 + 1))
                } else if nums[i] == nums[i - 1] + 2 {
                    (dp.1 + 1, dp.1 + 2)
                } else {
                    (1, 2)
                }
            };

            result = result.max(dp.0).max(dp.1);
            i = j;
        }

        result
    }
}
