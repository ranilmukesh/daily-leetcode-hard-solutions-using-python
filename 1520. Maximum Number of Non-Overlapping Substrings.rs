impl Solution {
    pub fn max_num_of_substrings(s: String) -> Vec<String> {
        let s_bytes = s.as_bytes();
        let n = s_bytes.len();
        
        // Step 1: Store the first and last occurrence of each character
        let mut first = vec![-1_i32; 26];
        let mut last = vec![-1_i32; 26];
        
        for i in 0..n {
            let c = (s_bytes[i] - b'a') as usize;
            if first[c] == -1 {
                first[c] = i as i32;
            }
            last[c] = i as i32;
        }
        
        let mut intervals = Vec::new();
        
        // Step 2: Find all valid minimal substrings
        for i in 0..26 {
            if first[i] == -1 {
                continue; // Character doesn't exist in string
            }
            
            let mut l = first[i] as usize;
            let mut r = last[i] as usize;
            let mut j = l;
            let mut is_valid = true;
            
            // Expand the substring to include all occurrences of inner characters
            while j <= r {
                let c = (s_bytes[j] - b'a') as usize;
                
                // If an inner character's first occurrence is before our starting point 'l',
                // it means to include this character we'd have to expand to the left. 
                // That violates our rule of checking intervals starting strictly at 'l'.
                if (first[c] as usize) < l {
                    is_valid = false;
                    break;
                }
                
                // Expand the right boundary if the inner character appears later in the string
                r = r.max(last[c] as usize);
                j += 1;
            }
            
            if is_valid {
                intervals.push((l, r));
            }
        }
        
        // Step 3: Sort intervals to prepare for Greedy Selection
        // Sort primarily by end point (ascending) to maximize the count of substrings.
        // If end points are the same, sort by start point (descending) to pick the shortest length.
        intervals.sort_by(|a, b| a.1.cmp(&b.1).then_with(|| b.0.cmp(&a.0)));
        
        // Step 4: Greedily pick non-overlapping intervals
        let mut res = Vec::new();
        let mut prev_end = -1_i32;
        
        for (l, r) in intervals {
            if (l as i32) > prev_end {
                res.push(s[l..=r].to_string());
                prev_end = r as i32;
            }
        }
        
        res
    }
}
