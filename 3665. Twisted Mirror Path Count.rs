const MOD:i32 = 1_000_000_007;
impl Solution {
    pub fn unique_paths(grid: Vec<Vec<i32>>) -> i32 {
        let mut line = vec![0; grid[0].len()];
        line[0] = 1;
        for row in grid.into_iter() {
            let mut fromleft = 0;
            for (cell, status) in line.iter_mut().zip(row.into_iter()) {
                if status == 1 {
                    (fromleft, *cell) = (*cell, fromleft);
                } else {
                    *cell += fromleft;
                    if *cell > MOD {*cell -= MOD}
                    fromleft = *cell;
                }
            }
        }
        return (line.pop().unwrap()) as i32;
    }
}
