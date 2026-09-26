use std::collections::HashMap;
impl Solution {
    pub fn evaluate(s: String, knowledge: Vec<Vec<String>>) -> String {
        let m = knowledge
            .iter()
            .map(|k| (k[0].as_bytes(), k[1].as_str()))
            .collect::<HashMap<_, _>>();
        let bytes = s.as_bytes();
        let mut ans = String::with_capacity(s.len());
        let mut i = 0;
        while i < bytes.len() {
            if bytes[i] == b'(' {
                let start = i + 1;
                let mut end = start;
                while end < bytes.len() && bytes[end] != b')' {
                    end += 1;
                }
                let key = &bytes[start..end];
                match m.get(key) {
                    Some(&val) => ans.push_str(val),
                    None => ans.push('?'),
                }
                i = end + 1;
            } else {
                let start = i;
                while i < bytes.len() && bytes[i] != b'(' {
                    i += 1;
                }
                ans.push_str(&s[start..i]);
            }
        }
        ans
    }
}
