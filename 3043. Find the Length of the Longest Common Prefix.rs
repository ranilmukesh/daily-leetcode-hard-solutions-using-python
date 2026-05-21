use std::collections::HashSet;
use std::iter::successors;

impl Solution {
    pub fn longest_common_prefix(arr1: Vec<i32>, arr2: Vec<i32>) -> i32 {
        if arr1.len() == 0 || arr2.len() == 0 { return 0; }
        let arr1_prefixes: HashSet<i32> = arr1
            .iter()
            .flat_map(|&x| successors(Some(x), |&n| (n >= 10).then_some(n / 10)))
            .collect();
        
        let mut longest = 0;
        for v in arr2 {
            let mut len = v.ilog10() as i32 + 1;
            for n in successors(Some(v), |&n| (n >= 10).then_some(n / 10)) {
                if arr1_prefixes.contains(&n) {
                    longest = longest.max(len);
                    break;
                }
                len -= 1;
            }
        }

        longest
    }
}
