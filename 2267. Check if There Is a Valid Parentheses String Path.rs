impl Solution {
    pub fn has_valid_path(grid: Vec<Vec<char>>) -> bool {
        let mut dp = vec![vec![0u128; 100]; 100];
        let (mut n, mut m) = (grid.len(), grid[0].len());

        if grid[0][0] == ')' || grid[n-1][m-1] == '(' { return false; }

        dp[0][0] |= 2;
        for i in 0..n {
            for j in 0..m {
                if grid[i][j] == ')' {
                    if i > 0 {
                        dp[i][j] |= (dp[i-1][j]>>1)
                    }
                    if j > 0 {
                        dp[i][j] |= (dp[i][j-1]>>1)
                    }
                } else {
                    if i > 0 {
                        dp[i][j] |= (dp[i-1][j]<<1)
                    }
                    if j > 0 {
                        dp[i][j] |= (dp[i][j-1]<<1)
                    }
                }
            }
        }
        dp[n-1][m-1] & 1 > 0
    }
}
