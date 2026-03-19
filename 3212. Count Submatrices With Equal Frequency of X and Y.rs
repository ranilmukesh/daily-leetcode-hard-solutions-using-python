impl Solution {
    pub fn number_of_submatrices(grid: Vec<Vec<char>>) -> i32 {
        let n = grid[0].len();
        let mut ps = vec![0; n];
        let mut ps_x = vec![false; n];
        let mut ans = 0;
        for row in grid {
            let mut s = 0;
            let mut has_x = false;
            for (j, c) in row.into_iter().enumerate() {
                match c {
                    'X' => {
                        s += 1;
                        has_x = true;
                    }
                    'Y' => s -= 1,
                    _ => (),
                }
                ps[j] += s;
                ps_x[j] |= has_x;
                if ps[j] == 0 && ps_x[j] {
                    ans += 1;
                }
            }
        }
        ans
    }
}
