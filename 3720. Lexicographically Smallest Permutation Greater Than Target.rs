impl Solution {
    pub fn lex_greater_permutation(s: String, target: String) -> String {
        let mut s = s.into_bytes();
        let target = target.as_bytes();

        let mut freq = [0; 26];

        for ch in s.drain(..) {
            freq[(ch - b'a') as usize] += 1;
        }

        for &ch in target.iter().take(target.len() - 1) {
            if freq[(ch - b'a') as usize] == 0 {
                break;
            }

            s.push(ch);
            freq[(ch - b'a') as usize] -= 1;
        }

        loop {
            if let Some((ch_idx, _)) = freq
                .iter()
                .enumerate()
                .skip((target[s.len()] - b'a') as usize + 1)
                .find(|&(_, &x)| x > 0)
            {
                s.push(ch_idx as u8 + b'a');
                freq[ch_idx] -= 1;

                for (ch_idx, &count) in freq.iter().enumerate() {
                    s.resize(s.len() + count as usize, ch_idx as u8 + b'a');
                }

                return String::from_utf8(s).unwrap();
            } else if let Some(ch) = s.pop() {
                freq[(ch - b'a') as usize] += 1;
            } else {
                return String::new();
            }
        }
    }
}
