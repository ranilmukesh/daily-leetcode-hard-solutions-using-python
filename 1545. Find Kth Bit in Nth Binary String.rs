impl Solution {
    pub fn find_kth_bit(n: i32, mut k: i32) -> char {
        // (2^n - 1) * 2 + 1 = 2^(n+1) - 1
        let mut sz = (1 << n) - 1;

        k -= 1;
        let mut inv = 0;
        loop {
            if sz == 1 {
                return ((0^inv) + ('0' as u8)) as char;
            }
            if k == sz/2 {
                return ((1^inv) + ('0' as u8)) as char;
            }

            sz /= 2;
            if k > sz {
                inv ^= 1;
                k = sz - (k - sz);
            }
        }
    }
}
