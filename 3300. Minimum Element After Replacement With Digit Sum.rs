impl Solution {
    pub fn min_element(nums: Vec<i32>) -> i32 {
        nums.into_iter().map(|mut n| {
            let mut sum = 0;
            while n > 0 {
                sum += n % 10;
                n /= 10;
            }
            sum
        }).min().unwrap()
    }
}
