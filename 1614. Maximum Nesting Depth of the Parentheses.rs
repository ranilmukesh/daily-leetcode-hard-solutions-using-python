impl Solution {
    pub fn max_depth(s: String) -> i32 {
        let mut  max_seen = 0;
        let mut  cur = 0;
        for ch in s.chars() {
            match ch {
                '(' => {
                    cur = cur + 1;
                    if cur > max_seen{
                        max_seen = cur;
                    }
                },
                ')' => {
                    cur = cur - 1;
                    
                },
                _ => {} // Ignore other characters
            }
        }
        return max_seen

    }
}
