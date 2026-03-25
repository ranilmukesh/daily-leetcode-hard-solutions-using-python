
impl Solution {
    pub fn can_partition_grid(grid: Vec<Vec<i32>>) -> bool {
        let sum: i64 = grid.iter().flat_map(|row| row.iter().map(|&x| x as i64)).sum();

        (grid
            .iter()
            .map(|row| row.iter().sum::<i32>())
            .scan(0i64, |acc, x| { *acc += x as i64; Some(*acc)})
            .any(|prefix| prefix == sum - prefix)
        ) || ((0..grid[0].len())
                .map(|j| grid.iter().map(|row| row[j]).sum::<i32>())
                .scan(0i64, |acc, x| { *acc += x as i64; Some(*acc)})
                .any(|prefix| prefix == sum - prefix)
        )
    }
}
