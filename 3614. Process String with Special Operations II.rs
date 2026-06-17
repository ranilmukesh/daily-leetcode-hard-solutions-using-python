impl Solution {
    pub fn process_str(s: String, mut k: i64) -> char {
        let mut l = 0;
        for b in s.bytes() {
            l += match b {
                42 => -l.min(1),
                35 => l,
                37 => 0,
                 _ => 1
            }
        }
        if k < l {
            for c in s.chars().rev() {
                match c {
                    '*' => l += 1,
                    '#' => { l /= 2; k %= l }
                    '%' => k = l + !k,
                    _ => if { l -= 1; k == l } { return c }
                }
            }
        }
        '.'
    }
}
