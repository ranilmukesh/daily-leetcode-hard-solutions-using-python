impl Solution {
    pub fn create_grid(m: i32, n: i32) -> Vec<String> {
        let rows = m as usize;
        let cols = n as usize;
        let mut grid = vec![vec!['#'; cols]; rows];

        for j in 0..cols {
            grid[0][j] = '.';
        }
        for i in 0..rows {
            grid[i][cols - 1] = '.';
        }

        grid.into_iter()
            .map(|row| row.into_iter().collect())
            .collect()
    }
}
