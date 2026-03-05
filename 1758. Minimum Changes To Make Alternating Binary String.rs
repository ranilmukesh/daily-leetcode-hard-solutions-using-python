impl Solution {
    pub fn min_operations(s: String) -> i32 {
        let mut res = 0;
        let mut bit = 0u8;
        for c in s.bytes() {
            res += ((c - b'0') ^ bit) as i32;
            bit ^= 1;
        }
        return res.min(s.len() as i32 - res);
    }
}
