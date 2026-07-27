impl Solution {
    pub fn max_product(nums: Vec<i32>) -> i32 {
        use itertools::Itertools;
        nums.iter().k_largest(2).map(|&x| x - 1).product()
    }
}
