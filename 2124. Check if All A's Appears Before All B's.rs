impl Solution {
    pub fn check_string(s: String) -> bool {
        !s.chars().skip_while(|&x| x == 'a').any(|x| x == 'a')
    }
}
