impl Solution {
    pub fn first_stable_index(nums: Vec<i32>, k: i32) -> i32 {
        let n: usize = nums.len();
        if (n == 1) {
            return 0;
        }
        let mut curr_max: i32 = nums[0];
        let mut curr_min: i32 = nums[n-1];
        let mut suff_min: Vec<i32> = vec![0; n];

        for i in (0..n).rev() {
            if nums[i] < curr_min {
                curr_min = nums[i];
            }
            suff_min[i] = curr_min;
        }
        for i in 0..n {
            if (nums[i] > curr_max) {
                curr_max = nums[i];
            }
            if (curr_max - suff_min[i] <= k) {
                return i as i32;
            }
        }
        -1
    }
}
