impl Solution {
    pub fn check_ones_segment(s: String) -> bool {
        (s.as_bytes()[0] == b'1') as i32 + s.as_bytes().windows(2).filter(|w| w == b"01").count() as i32 <= 1
    }
}
