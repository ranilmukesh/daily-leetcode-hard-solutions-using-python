use std::collections::HashSet;

impl Solution {
    pub fn robot_sim(commands: Vec<i32>, obstacles: Vec<Vec<i32>>) -> i32 {
        let dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)];
        let mut dir = 0;
        let mut x = 0;
        let mut y = 0;
        let mut max = 0;
        let obstacles_set: HashSet<(i32, i32)> = obstacles
            .into_iter()
            .map(|v| (v[0], v[1]))
            .collect();

        for &cmd in commands.iter() {
            if cmd == -2 {
                dir = (dir + 3) % 4;
            } else if cmd == -1 {
                dir = (dir + 1) % 4;
            } else {
                let (dx, dy) = dirs[dir];
                for _ in 0..cmd {
                    let nx = x + dx;
                    let ny = y + dy;
                    if obstacles_set.contains(&(nx, ny)) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    max = max.max(x * x + y * y);
                }
            }
        }
        max
    }
}
