use std::collections::VecDeque;
impl Solution {
    pub fn can_reach(s: String, min_jump: i32, max_jump: i32) -> bool {
        let n = s.len();
        let min_jump = min_jump as usize;
        let max_jump = max_jump as usize;
        let mut que: VecDeque<usize> = VecDeque::new();
        que.push_back(0);
        for (i, b) in s.bytes().enumerate() {
            if (if let Some(&val) = que.front() { val + max_jump < i } else { false }) { que.pop_front(); }
            if que.is_empty() { return false; }
            if b == 48 && *que.front().expect("") + min_jump <= i { que.push_back(i);  } 
        }
        *que.back().expect("") == n-1
    }
}
