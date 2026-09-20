impl Solution {
    pub fn reverse_degree(s: String) -> i32 {
        s.into_bytes().iter().enumerate().fold(0, |acc, (i, &val) | acc + (26 - (val as i32 - 97)) * (i as i32 + 1))
    }
}
