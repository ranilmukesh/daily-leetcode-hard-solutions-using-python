use itertools::Itertools;

impl Solution {
    pub fn min_abs_diff(grid: Vec<Vec<i32>>, k: i32) -> Vec<Vec<i32>> {
        (0..grid.len()-k as usize+1).map(|i| {
            (0..grid[0].len()-k as usize+1).map(|j| {
                grid.iter()
                    .skip(i)
                    .take(k as usize)
                    .flat_map(|row| row.iter().skip(j).take(k as usize))
                    .sorted()
                    .dedup()
                    .tuple_windows()
                    .map(|(&a, &b)| b-a)
                    .min()
                    .unwrap_or(0)
            }).collect()
        }).collect()
    }
}
