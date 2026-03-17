impl Solution {
    pub fn largest_submatrix(mut matrix: Vec<Vec<i32>>) -> i32 {
        let m = matrix.len();
        let n = matrix[0].len();
        let mut max_area = 0;

        // Build heights
        for i in 1..m {
            for j in 0..n {
                if matrix[i][j] != 0 {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }

        // For each row
        for i in 0..m {
            let mut row = matrix[i].clone();
            row.sort_unstable_by(|a, b| b.cmp(a)); // descending

            for j in 0..n {
                let area = row[j] * (j as i32 + 1);
                max_area = max_area.max(area);
            }
        }

        max_area
    }
}
