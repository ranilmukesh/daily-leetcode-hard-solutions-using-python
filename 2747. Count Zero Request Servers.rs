impl Solution {
    pub fn count_servers(n: i32, mut logs: Vec<Vec<i32>>, x: i32, queries: Vec<i32>) -> Vec<i32> {
        logs.sort_unstable_by_key(|l| l[1]);
        let mut indexed_queries: Vec<(i32, usize)> = queries
            .into_iter()
            .enumerate()
            .map(|(i, q)| (q, i))
            .collect();
        indexed_queries.sort_unstable_by_key(|iq| iq.0);

        let mut server_counts = vec![0; n as usize + 1];
        let mut active_servers = 0;
        let mut ans = vec![0; indexed_queries.len()];

        let mut left = 0;
        let mut right = 0;
        let num_logs = logs.len();

        for (q_time, q_idx) in indexed_queries {
            let window_start = q_time - x;

            while right < num_logs && logs[right][1] <= q_time {
                let s_id = logs[right][0] as usize;
                if server_counts[s_id] == 0 {
                    active_servers += 1;
                }
                server_counts[s_id] += 1;
                right += 1;
            }

            while left < num_logs && logs[left][1] < window_start {
                let s_id = logs[left][0] as usize;
                server_counts[s_id] -= 1;
                if server_counts[s_id] == 0 {
                    active_servers -= 1;
                }
                left += 1;
            }

            ans[q_idx] = n - active_servers;
        }

        ans
    }
}
