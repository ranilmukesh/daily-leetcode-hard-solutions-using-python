impl Solution {
    pub fn longest_valid_parentheses(s: String) -> i32 {
        let mut l = 0i32;
        let mut r = 0i32;
        let mut best = 0i32;

        for c in s.chars() {
            if c == '(' {
                l += 1;
            } else {
                r += 1;
            }

            if l == r {
                best = std::cmp::max(best, r * 2)
            } else if r > l {
                l = 0;
                r = 0;
            }
        }

        l = 0;
        r = 0;
        for c in s.chars().rev() {
            if c == '(' {
                l += 1;
            } else {
                r += 1;
            }

            if l == r {
                best = std::cmp::max(best, l * 2)
            } else if r < l {
                l = 0;
                r = 0;
            }
        }

        best
    }
}
