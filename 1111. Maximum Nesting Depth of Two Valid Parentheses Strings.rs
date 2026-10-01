impl Solution {
    pub fn max_depth_after_split(seq: String) -> Vec<i32> {
        let mut s1 = 0;
        let mut s2 = 0;
        let mut ans = Vec::with_capacity(seq.len());

        seq.chars().for_each(|ch| match ch {
            '(' => {
                if s1 < s2 {
                    ans.push(0);
                    s1 += 1;
                } else {
                    ans.push(1);
                    s2 += 1;
                }
            }
            ')' => {
                if s1 > s2 {
                    ans.push(0);
                    s1 -= 1;
                } else {
                    ans.push(1);
                    s2 -= 1;
                }
            }
            x => unreachable!("Found chars other than '(' and ')' {}", x),
        });

        ans
    }
}
