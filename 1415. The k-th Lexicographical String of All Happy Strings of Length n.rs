impl Solution {
    pub fn get_happy_string(n: i32, k: i32) -> String {
        let mut count = 0;
        let mut current_s = String::with_capacity(n as usize);

        fn backtrack(
            n: usize, 
            k: i32, 
            count: &mut i32, 
            current_s: &mut String
        ) -> Option<String> {
            if current_s.len() == n {
                *count += 1;
                if *count == k {
                    return Some(current_s.clone());
                }
                return None;
            }

            for c in ['a', 'b', 'c'] {
                if current_s.is_empty() || current_s.chars().last().unwrap() != c {
                    current_s.push(c);
                    
                    if let Some(result) = backtrack(n, k, count, current_s) {
                        return Some(result);
                    }
                    
                    current_s.pop();
                }
            }
            None
        }

        backtrack(n as usize, k, &mut count, &mut current_s).unwrap_or_default()
    }
}
