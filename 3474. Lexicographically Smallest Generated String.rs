impl Solution {
    pub fn generate_string(str1: String, str2: String) -> String {
        let n1 = str1.len(); let m = str2.len();
        let total = n1 + m - 1;
        let s1 = str1.as_bytes(); let s2 = str2.as_bytes();
        let mut forced = vec![false; total];
        let mut result: Vec<Option<u8>> = vec![None; total];
        // For each T position, force the substring to equal str2
        for i in 0..n1 {
            if s1[i] == b'T' {
                for j in 0..m {
                    let pos = i + j;
                    if result[pos].is_none() { result[pos] = Some(s2[j]); }
                    else if result[pos] != Some(s2[j]) { return String::new(); }
                    forced[pos] = true;
                }
            }
        }
        // Fill unset positions with 'a'
        let mut result: Vec<u8> = result.into_iter().map(|c| c.unwrap_or(b'a')).collect();
        // For each F position, ensure substring != str2 (change rightmost unforced char if needed)
        for i in 0..n1 {
            if s1[i] == b'F' && &result[i..i+m] == s2 {
                let mut changed = false;
                for j in (0..m).rev() {
                    let pos = i + j;
                    if !forced[pos] {
                        result[pos] = if s2[j] == b'a' { b'b' } else { b'a' };
                        changed = true;
                        break;
                    }
                }
                if !changed { return String::new(); }
            }
        }
        String::from_utf8(result).unwrap()
    }
}
