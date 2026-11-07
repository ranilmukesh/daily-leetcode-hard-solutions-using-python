use std::cmp::Reverse;
use std::collections::BinaryHeap;

impl Solution {
    pub fn assign_tasks(servers: Vec<i32>, tasks: Vec<i32>) -> Vec<i32> {
        // (weight, index): lightest server, then smallest index
        let mut free_servers: BinaryHeap<Reverse<(i32, i32)>> =
            BinaryHeap::new();

        // (available_time, weight, index): earliest time first
        let mut wait_servers: BinaryHeap<Reverse<(i64, i32, i32)>> =
            BinaryHeap::new();

        for (i, weight) in servers.into_iter().enumerate() {
            free_servers.push(Reverse((weight, i as i32)));
        }

        let mut res = Vec::with_capacity(tasks.len());
        let mut time: i64 = 0;

        for (i, task) in tasks.into_iter().enumerate() {
            time = time.max(i as i64);

            // Release every server that is available now.
            while let Some(&Reverse((available, weight, index))) =
                wait_servers.peek()
            {
                if available > time {
                    break;
                }

                wait_servers.pop();
                free_servers.push(Reverse((weight, index)));
            }

            // If no server is free, jump to the next availability time.
            if free_servers.is_empty() {
                time = wait_servers.peek().unwrap().0.0;

                while let Some(&Reverse((available, weight, index))) =
                    wait_servers.peek()
                {
                    if available > time {
                        break;
                    }

                    wait_servers.pop();
                    free_servers.push(Reverse((weight, index)));
                }
            }

            // Assign the best available server.
            let Reverse((weight, index)) = free_servers.pop().unwrap();
            res.push(index);

            // This server becomes available after processing the task.
            wait_servers.push(Reverse((
                time + task as i64,
                weight,
                index,
            )));
        }

        res
    }
}
