impl Solution {
    pub fn max_value(n: Vec<i32>) -> Vec<i32> {
        let mut m = 0; let mut r:Vec<_> = (0..n.len()).map(|i| { m=m.max(n[i]);m}).collect();
        for i in (0..n.len()).rev() {
            if r[i] > m { r[i] = r[i+1]}; m = m.min(n[i])
        }; r
    }
}
