impl Solution {
    pub fn count_servers(grid: Vec<Vec<i32>>) -> i32 {
        let m = grid.len();
        let n = grid[0].len();

        let mut rows = vec![0; m];
        let mut columns = vec![0; n];

        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 {
                    rows[i] += 1;
                    columns[j] += 1;
                }
            }
        }

        let mut result = 0;
        for i in 0..m {
            for j in 0..n {
                if grid[i][j] == 1 && (rows[i] > 1 || columns[j] > 1) {
                    result += 1;
                }
            }
        }

        result
    }
}
