impl Solution {
    pub fn contains_cycle(grid: Vec<Vec<char>>) -> bool {
        let m = grid.len();
        let n = grid[0].len();

        let mut parent: Vec<usize> = (0..m * n).collect();

        fn find(parent: &mut Vec<usize>, a: usize) -> usize {
            if parent[a] != a {
                parent[a] = find(parent, parent[a]);
            }
            parent[a]
        }

        fn union(parent: &mut Vec<usize>, a: usize, b: usize) -> bool {
            let ra = find(parent, a);
            let rb = find(parent, b);

            if ra == rb {
                return true;
            }

            parent[rb] = ra;
            false
        }

        for i in 0..m {
            for j in 0..n {
                let idx = i * n + j;

                if i + 1 < m && grid[i][j] == grid[i + 1][j] {
                    if union(&mut parent, idx, idx + n) {
                        return true;
                    }
                }

                if j + 1 < n && grid[i][j] == grid[i][j + 1] {
                    if union(&mut parent, idx, idx + 1) {
                        return true;
                    }
                }
            }
        }

        false
    }
}
