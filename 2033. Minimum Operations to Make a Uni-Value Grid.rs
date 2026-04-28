impl Solution {
    pub fn min_operations(grid: Vec<Vec<i32>>, x: i32) -> i32 {
        let rem = grid[0][0] % x;
        let mut vals = Vec::new();
        for row in grid {
            for v in row {
                if v % x != rem {
                    return -1;
                }
                vals.push(v / x);
            }
        }
        vals.sort_unstable();
        let target = vals[vals.len() / 2];
        vals.into_iter().map(|v| (v - target).abs()).sum()
    }
}
