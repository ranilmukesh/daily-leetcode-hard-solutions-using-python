impl Solution {
    pub fn generate_parenthesis(n: i32) -> Vec<String> {
        let mut s = String::with_capacity(n as usize * 2);
        let mut v = Vec::new();
        Solution::solve(n, 0, &mut s, &mut v);

        v
    }

    fn solve(n: i32, balance: i32, s: &mut String, v: &mut Vec<String>) {
        if n == 0 && balance == 0 {
            v.push(s.clone());
            return;
        }

        if n == 0 {
            s.push(')');
            Solution::solve(n, balance - 1, s, v);
            s.pop();
            return;
        }

        if balance == 0 {
            s.push('(');
            Solution::solve(n - 1, 1, s, v);
            s.pop();
            return;
        }

        s.push('(');
        Solution::solve(n - 1, balance + 1, s, v);
        s.pop();

        s.push(')');
        Solution::solve(n, balance - 1, s, v);
        s.pop();
    }
}
