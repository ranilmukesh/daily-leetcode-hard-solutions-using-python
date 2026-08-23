impl Solution {
    pub fn check_divisibility(n: i32) -> bool {
        let (mut t, mut s, mut p) = (n, 0, 1);
        while t > 0 { s += t % 10; p *= t % 10; t /= 10 }
        n % (s + p) == 0
    }
}
