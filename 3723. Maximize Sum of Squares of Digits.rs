impl Solution {
    pub fn max_sum_of_squares(num: i32, mut sum: i32) -> String {
        if sum > num * 9 {
            return String::new();
        }
        let mut r = String::with_capacity(num as usize);
        r.push_str("9".repeat((sum / 9) as usize).as_str());
        sum %= 9;
        if sum.is_positive() {
            r.push((sum as u8 + b'0') as char);
        }
        r.push_str("0".repeat(num as usize - r.len()).as_str());
        r
    }
}
