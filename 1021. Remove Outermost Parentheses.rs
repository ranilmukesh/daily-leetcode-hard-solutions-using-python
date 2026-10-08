impl Solution {
    pub fn remove_outer_parentheses(s: String) -> String {
        let mut ans = String::with_capacity(s.len());
        let mut balance = 0;

        for ch in s.chars() {
            if !(balance == 0 || (ch == ')' && balance == 1)) {
                ans.push(ch);
            }

            if ch == ')' {
                balance -= 1;
            } else {
                balance += 1;
            }
        }

        ans
    }
}
