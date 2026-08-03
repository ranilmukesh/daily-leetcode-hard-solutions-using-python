use std::cmp::max;

impl Solution {
    pub fn stone_game_iii(mut stone_value: Vec<i32>) -> String {
        let n = stone_value.len();

        // This makes our live easier for short the dynamic programming base case
        for _ in 0..3 {
            stone_value.push(0);
        }

        let mut max_diff_at = (0, 0, 0);

        for i in (0..=n-1).rev() {
            let one_stone_diff = stone_value[i] - max_diff_at.0;
            let two_stone_diff = stone_value[i] + stone_value[i+1] - max_diff_at.1;
            let three_stone_diff = stone_value[i] + stone_value[i+1] + stone_value[i+2] - max_diff_at.2;

            let best = max(one_stone_diff, max(two_stone_diff, three_stone_diff));
            max_diff_at = (best, max_diff_at.0, max_diff_at.1);
        }
        

        let result = if max_diff_at.0 > 0 {
            "Alice"
        } else if max_diff_at.0 == 0 {
            "Tie"
        } else {
            "Bob"
        };

        result.to_string()
    }
}
