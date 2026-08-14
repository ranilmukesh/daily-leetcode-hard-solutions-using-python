impl Solution {
    pub fn maximum_length_substring(s: String) -> i32 {
        let bytes = s.as_bytes();
        let mut freq = [0; 26];
        let mut left = 0;
        let mut max_len = 0;

        for right in 0..bytes.len() {
            let right_idx = (bytes[right] - b'a') as usize;
            freq[right_idx] += 1;

            while freq[right_idx] > 2 {
                let left_idx = (bytes[left] - b'a') as usize;
                freq[left_idx] -= 1;
                left += 1;
            }

            max_len = max_len.max(right - left + 1);
        }

        max_len as i32
    }
}
