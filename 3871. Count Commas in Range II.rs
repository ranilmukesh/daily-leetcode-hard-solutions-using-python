impl Solution {
    pub fn count_commas(n: i64) -> i64 {
        let order = n.ilog10() / 3;

        if order < 1 {
            return 0;
        }

        (1..=order).into_iter().fold(0, |acc, o| {
            let min = 10i64.pow(o*3) - 1;
            let max = 10i64.pow((o+1)*3) - 1;

            acc + (n.min(max) - min) * o as i64
        })
    }
}
