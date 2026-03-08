use std::collections::HashSet;

impl Solution {
    fn find_different_binary_string(nums: Vec<String>) -> String {
        let set: HashSet<String> = nums.iter().cloned().collect();
        let n = nums[0].len();
        let mut result = String::new();

        fn g(s: String, i: usize, n: usize, set: &HashSet<String>, result: &mut String) -> bool {
            if i == n {
                if set.contains(&s) {
                    return false;
                }
                *result = s;
                return true;
            }

            if g(s.clone() + "0", i + 1, n, set, result) {
                return true;
            }
            if g(s.clone() + "1", i + 1, n, set, result) {
                return true;
            }

            false
        }

        g(String::new(), 0, n, &set, &mut result);

        result
    }
}
