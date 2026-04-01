impl Solution {
    pub fn survived_robots_healths(positions: Vec<i32>, mut healths: Vec<i32>, directions: String) -> Vec<i32> {
        let n = positions.len();
        let dirs: Vec<u8> = directions.bytes().collect();
        let mut order: Vec<usize> = (0..n).collect();
        order.sort_unstable_by_key(|&i| positions[i]);

        let mut stack: Vec<usize> = vec![]; // indices of 'R' moving robots (by position)

        for &i in &order {
            if dirs[i] == b'R' {
                stack.push(i);
            } else {
                // 'L' robot collides with rightmost 'R' robots
                while let Some(&j) = stack.last() {
                    if healths[j] < healths[i] {
                        healths[j] = 0;
                        healths[i] -= 1;
                        stack.pop();
                    } else if healths[j] > healths[i] {
                        healths[j] -= 1;
                        healths[i] = 0;
                        break;
                    } else {
                        healths[j] = 0;
                        healths[i] = 0;
                        stack.pop();
                        break;
                    }
                }
            }
        }
        (0..n).filter(|&i| healths[i] > 0).map(|i| healths[i]).collect()
    }
}
