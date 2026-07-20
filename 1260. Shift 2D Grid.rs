impl Solution {
    pub fn shift_grid(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        let m = grid.len();
        if m == 0 { return grid; }
        let n = grid[0].len();
        let total = m * n;
        let k = (k as usize) % total;

        let mut flat = Vec::with_capacity(total);
        for row in &grid {
            for &val in row {
                flat.push(val);
            }
        }

        let mut result = vec![vec![0; n]; m];
        for i in 0..total {
            let new_pos = (i + k) % total;
            let r = new_pos / n;
            let c = new_pos % n;
            result[r][c] = flat[i];
        }

        result
    }
}
