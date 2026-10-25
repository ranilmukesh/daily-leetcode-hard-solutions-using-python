impl Solution {
    pub fn fill(grid: &mut Vec<Vec<i32>>, i: i32, j: i32, marker: i32) -> i32
    {
        let n = grid.len();
        let m = grid[0].len();
        if ((i < 0) | (j < 0) | (i == n as i32) | (j == m as i32))
        {
            return 1;
        }
        let ind = i as usize;
        let jnd = j as usize;
        if grid[ind][jnd] != 0
        {
            return 0;
        }
        let mut verif = 0;
        grid[ind][jnd] = marker;
        verif += Self::fill(grid, i+1, j, marker);
        verif += Self::fill(grid, i-1, j, marker);
        verif += Self::fill(grid, i, j+1, marker);
        verif += Self::fill(grid, i, j-1, marker);
        return verif; 
    }
    pub fn closed_island(mut grid: Vec<Vec<i32>>) -> i32 {
        let mut marker = -1;
        let n = grid.len();
        let m = grid[0].len();
        let mut count = 0;
        for i in 0..n
        {
            for j in 0..m
            {
                if grid[i][j] == 0
                {
                    let t = Self::fill(&mut grid, i as i32, j as i32, marker);
                    marker -= 1;
                    if t == 0
                    {
                        count += 1;
                    }
                }
            }
        }
        count
    }
}
