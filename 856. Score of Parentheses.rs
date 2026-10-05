impl Solution {
    pub fn score_of_parentheses(s: String) -> i32 {
    let mut stack = vec![0];
    for ch in s.chars(){
        if ch == '('{
            stack.push(0);
        } else {
            let k = stack.pop().unwrap();
            let len = stack.len();
            if k == 0 {
                stack[len - 1] += 1;
            } else {
                stack[len - 1] += 2 * k;
            }
        }
    }
    stack[0]
}
}
