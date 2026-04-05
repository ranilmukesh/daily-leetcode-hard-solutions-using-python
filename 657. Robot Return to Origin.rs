impl Solution {
    pub fn judge_circle(moves: String) -> bool {
        let u = moves.chars().filter(|&c|c=='U').count();
        let d = moves.chars().filter(|&c|c=='D').count();
        let l = moves.chars().filter(|&c|c=='L').count();
        let r = moves.chars().filter(|&c|c=='R').count();
        u == d && l == r
    }
}
