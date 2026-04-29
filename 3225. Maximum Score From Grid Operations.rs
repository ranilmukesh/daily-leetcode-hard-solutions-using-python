impl Solution {
    #[allow(unused)]
    pub fn maximum_score(grid: Vec<Vec<i32>>) -> i64 {
        let n = grid.len();
        let mut prefix = vec![vec![0i64; n + 1]; n];
        for i in 0..n {
            for j in 0..n {
                prefix[i][j + 1] = prefix[i][j] + (grid[j][i] as i64);
            }
        }

        let mut dp_pick = vec![vec![0i64; n + 1]; n];
        let mut dp_skip = vec![vec![0i64; n + 1]; n];

        for i in 1..n {
            for curr in 0..=n {
                for prev in 0..=n {
                    if curr > prev {
                        let candidate = prefix[i - 1][curr] - prefix[i - 1][prev];
                        dp_pick[i][curr] = std::cmp::max(dp_pick[i][curr], dp_skip[i - 1][prev] + candidate);
                        dp_skip[i][curr] = std::cmp::max(dp_skip[i][curr], dp_skip[i - 1][prev] + candidate);
                    } else {
                        let candidate = prefix[i][prev] - prefix[i][curr];
                        dp_pick[i][curr] = std::cmp::max(dp_pick[i][curr], dp_pick[i - 1][prev] + candidate);
                        dp_skip[i][curr] = std::cmp::max(dp_skip[i][curr], dp_pick[i - 1][prev]);
                    }
                }
            }
        }


        return dp_pick[n - 1].iter().max().unwrap().clone();
    }
}
