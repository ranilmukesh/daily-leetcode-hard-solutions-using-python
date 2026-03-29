impl Solution {
    pub fn can_be_equal(s1: String, s2: String) -> bool {
        let (mut s1,mut s2) = (s1.chars().collect::<Vec<char>>(),s2.chars().collect::<Vec<char>>());
        for idx in 0..s1.len() {
            if s1[idx] == s2[idx] {continue}
            if idx<s1.len()-2 && s1[idx+2] == s2[idx] {(s1[idx],s1[idx+2]) = (s1[idx+2],s1[idx]);continue}
            return false
        }
        true
    }
}
