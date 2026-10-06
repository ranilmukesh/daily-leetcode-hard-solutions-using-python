impl Solution {
    pub fn min_add_to_make_valid(s: String) -> i32 {
        let mut opens: i32 = 0;
        let mut closed: i32 = 0;

        for b in s.bytes() {
            match b {
                b'(' => { opens += 1; },
                _ => {
                    if opens > 0 {
                        opens -= 1;
                    }else {
                        closed += 1;
                    }
                },
            }
        }

        return opens + closed;
    }
}
