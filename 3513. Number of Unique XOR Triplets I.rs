impl Solution {
    pub fn unique_xor_triplets(n: Vec<i32>) -> i32 {
        let l = n.len() as i32; if l < 3 { l } else { 1 << (32 - l.leading_zeros()) }
    }
}
