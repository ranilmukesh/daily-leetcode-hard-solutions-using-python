impl Solution {
    pub fn mirror_distance(mut n: i32) -> i32 {
        let old_n = n;
        let mut rev = 0;

        while n > 0 {
            rev = rev*10 + n%10;
            n /= 10;
        }

        rev.abs_diff(old_n) as i32
    }
}
