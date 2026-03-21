impl Solution {
    pub fn reverse_submatrix(mut grid: Vec<Vec<i32>>, x: i32, y: i32, k: i32) -> Vec<Vec<i32>> {
        let (k,x,y) = (k as usize,x as usize,y as usize);
        for row in 0..k/2 {
            for col in y..y+k {
                (grid[x+row][col],grid[x+k-row-1][col]) = (grid[x+k-row-1][col],grid[x+row][col]);
            }
        }
        grid
    }
}
