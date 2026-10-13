impl Solution {
    pub fn max_alternating_sum(mut nums: Vec<i32>) -> i64 {
        let n = nums.len();
        let (lesser, median, greater) = nums.select_nth_unstable_by_key(n / 2, |&num| num.abs());

        let mut ans = (*median as i64) * (*median as i64);

        ans += greater
            .into_iter()
            .map(|&mut num| (num as i64) * (num as i64))
            .sum::<i64>();

        ans -= lesser
            .into_iter()
            .map(|&mut num| (num as i64) * (num as i64))
            .sum::<i64>();

        ans
    }
}
