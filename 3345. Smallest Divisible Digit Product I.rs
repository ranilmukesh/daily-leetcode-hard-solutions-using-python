impl Solution {
    pub fn smallest_number(n: i32, t: i32) -> i32 {
        return (n..=100).skip_while(|&v| (v.to_string().chars().map(|v| v as i32 - '0' as i32).fold(1, |a, b| a * b)) % t != 0).next().unwrap();
    }
}
