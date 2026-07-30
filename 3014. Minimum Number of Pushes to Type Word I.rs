impl Solution {
    pub fn minimum_pushes(word: String) -> i32 {
        let n = word.len() as i32;

        if n <= 8 {
            n
        } else if n > 8 && n <= 16 {
            8 + (n - 8) * 2
        } else if n > 16 && n <= 24 {
            8 + 8 * 2 + (n - 16) * 3
        } else {
            8 + 8 * 2 + 8 * 3 + (n - 24) * 4
        }
    }
}
