impl Solution {
    pub fn process_str(s: String) -> String {
        let mut result = String::with_capacity(s.len() << 4);

        for char in s.chars() {
            match char {
                '*' => {
                    result.pop();
                }
                '#' => {
                    result.extend_from_within(0..);
                }
                '%' => {
                    result = result.chars().rev().collect();
                }
                _ => {
                    result.push(char);
                }
            }
        }

        result
    }
}
