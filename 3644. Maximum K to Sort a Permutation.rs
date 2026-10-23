impl Solution {
    pub fn sort_permutation(nums: Vec<i32>) -> i32 {
        let mut k = -1;

        for (i, &x) in nums.iter().enumerate() {
            if x != i as i32 {
                k &= x;
            }
        }

        k.max(0)
    }
}
