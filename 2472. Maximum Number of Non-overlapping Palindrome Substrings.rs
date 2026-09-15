impl Solution {
    pub fn max_palindromes(s: String, k: i32) -> i32 {
        let k = k as usize;
        let bytes = s.as_bytes(); 
        let mut count = 0;
        let mut i = 0;

        let is_palindrome = |slice: &[u8]| {
            slice.iter().eq(slice.iter().rev())
        };
        while i + k <= bytes.len() {
            if is_palindrome(&bytes[i..i + k]) {
                count += 1;
                i += k; 
            } 
            else if i + k < bytes.len() && is_palindrome(&bytes[i..i + k + 1]) {
                count += 1;
                i += k + 1;
            } 
            else {
                i += 1;
            }
        }

        count
    }
}
