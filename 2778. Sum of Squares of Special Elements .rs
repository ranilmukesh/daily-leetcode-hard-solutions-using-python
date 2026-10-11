impl Solution {
    pub fn sum_of_squares(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        nums.into_iter().enumerate().fold(0i32, |acc, (idx, num)| {
            if n.is_multiple_of(idx + 1) {
                acc + num * num
            } else {
                acc
            }
        })
    }
}
