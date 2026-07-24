impl Solution {
    pub fn unique_xor_triplets(mut n: Vec<i32>) -> i32 {
        n.sort_unstable(); n.dedup();
        let mut s = [false; 1 << 12]; let mut t = s.clone();
        for i in 0..n.len() { for j in i..n.len() { s[(n[i] ^ n[j]) as usize] = true }}
        for x in 0..s.len() { if s[x] { for &v in &n { t[x ^ v as usize] = true }}}
        t.iter().filter(|&&b| b).count() as _
    }
}
