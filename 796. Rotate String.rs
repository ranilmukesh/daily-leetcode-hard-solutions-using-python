impl Solution {
    pub fn rotate_string(mut s: String, goal: String) -> bool {
        s.len() == goal.len() && {
            s.extend_from_within(..);
            s.contains(&goal)
        }
    }
}
