use std::collections::VecDeque;

// Okay, so there are two states for a neighbour: positive integer, or 0/border.
// This time we need to count the sum of island cells.
// Eh, just go through the grid with either dfs or bfs.
impl Solution {
    pub fn count_islands(mut grid: Vec<Vec<i32>>, k: i32) -> i32 {
        let k = k as i64;
        let n = grid.len();
        let m = grid[0].len();
        // Allocate one queue and reuse it instead of creating a new one for each island.
        let mut queue = VecDeque::with_capacity(n * m);
        (0..n).fold(0, |good_island_counter, row_idx| {
            (0..m).fold(good_island_counter, |good_island_counter, col_idx| {
                let this_cell_value = grid[row_idx][col_idx];
                if this_cell_value > 0 {
                    queue.push_back((row_idx as u16, col_idx as u16));
                    grid[row_idx][col_idx] = 0;
                    let island_sum = this_cell_value as i64 + bfs(&mut grid, &mut queue);
                    if island_sum % k == 0 {
                        return good_island_counter + 1;
                    }
                }

                good_island_counter
            })
        })
    }
}

fn bfs(grid: &mut [Vec<i32>], queue: &mut VecDeque<(u16, u16)>) -> i64 {
    let mut sum = 0;
    while let Some((x, y)) = queue.pop_front() {
        let xu = x as usize;
        let yu = y as usize;

        // If a neighbour is a cell with a value > 0:
        // add the value to the sum, set the cell value to 0, and add cell coordinates to the queue.
        if let Some(val) = grid.get_mut(xu + 1).and_then(|row| row.get_mut(yu))
            && *val > 0
        {
            sum += *val as i64;
            *val = 0;
            queue.push_back((x + 1, y));
        }
        if let Some(val) = grid
            .get_mut(xu.wrapping_sub(1))
            .and_then(|row| row.get_mut(yu))
            && *val > 0
        {
            sum += *val as i64;
            *val = 0;
            queue.push_back((x - 1, y));
        }
        if let Some(val) = grid.get_mut(xu).and_then(|row| row.get_mut(yu + 1))
            && *val > 0
        {
            sum += *val as i64;
            *val = 0;
            queue.push_back((x, y + 1));
        }
        if let Some(val) = grid
            .get_mut(xu)
            .and_then(|row| row.get_mut(yu.wrapping_sub(1)))
            && *val > 0
        {
            sum += *val as i64;
            *val = 0;
            queue.push_back((x, y - 1));
        }
    }

    sum
}
