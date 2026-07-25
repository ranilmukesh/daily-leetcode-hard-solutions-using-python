impl Solution {
    pub fn max_product(n: i32) -> i32 {
        use itertools::Itertools;
        n.to_string().chars().combinations(2).fold(0, |s, x| {
            s.max(x[0].to_digit(10).unwrap() * x[1].to_digit(10).unwrap())
        }) as i32
    }
}
