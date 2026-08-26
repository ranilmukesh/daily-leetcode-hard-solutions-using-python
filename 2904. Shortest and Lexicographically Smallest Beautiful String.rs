impl Solution {
    pub fn shortest_beautiful_substring(s: String, k: i32) -> String {
        let chars: Vec<char> = s.chars().collect();
        let n = chars.len();
        let mut i = 0;
        let mut j = 0;
        let mut c = 0;
        let k = k as usize;
        
        while i < n && chars[i] == '0' {
            i += 1;
        }
        
        j = i;
        
        while j < n && c < k {
            if chars[j] == '1' {
                c += 1;
            }
            j += 1;
        }
        
        if c != k {
            return String::new();
        }
        
        if j - i == k {
            return chars[i..j].iter().collect();
        }
        
        let mut r: String = chars[i..j].iter().collect();
        let mut l = r.len();
        
        while j < n {
            while j < n && chars[j] == '0' {
                j += 1;
            }
            
            if j == n {
                break;
            }
            
            i += 1;
            while chars[i] == '0' {
                i += 1;
            }
            
            let len = j - i + 1;
    
            if len < l {
                r = chars[i..=j].iter().collect();
                l = len;
                
                
                if l == k {
                    return r;
                }
            }
            else if len == l {
                let candidate: String = chars[i..=j].iter().collect();
                if candidate < r {
                    r = candidate;
                }
            }
            
            j += 1;
        }
        
        r
    }
}
