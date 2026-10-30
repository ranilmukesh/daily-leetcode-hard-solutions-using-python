use std::cmp::Reverse;
use std::collections::BinaryHeap;

impl Solution {
    // O(E * k log(n * k)) time, O(n * k + E) space
    pub fn shortest_path(n: i32, edges: Vec<Vec<i32>>, labels: String, k: i32) -> i32 {
        let n = n as usize;
        let k = k as usize;
        let label = labels.as_bytes();
        if n == 1 {
            return 0;
        }

        let mut head = vec![usize::MAX; n];
        let mut next = vec![usize::MAX; edges.len()];
        let mut target = vec![0usize; edges.len()];
        let mut weight = vec![0u32; edges.len()];
        for (e, edge) in edges.iter().enumerate() {
            let u = edge[0] as usize;
            target[e] = edge[1] as usize;
            weight[e] = edge[2] as u32;
            next[e] = head[u];
            head[u] = e;
        }

        // a state is a node plus how many identical labels the path currently ends on
        let mut dist = vec![u32::MAX; n * k];
        dist[0] = 0;
        let mut queue = BinaryHeap::new();
        queue.push(Reverse((0u32, 0usize)));
        while let Some(Reverse((d, state))) = queue.pop() {
            if d > dist[state] {
                continue;
            }
            let node = state / k;
            let run = state % k + 1;
            if node == n - 1 {
                return d as i32;
            }
            let mut e = head[node];
            while e != usize::MAX {
                let v = target[e];
                let grown = if label[v] == label[node] { run + 1 } else { 1 };
                if grown <= k {
                    let next_dist = d + weight[e];
                    let next_state = v * k + grown - 1;
                    if next_dist < dist[next_state] {
                        dist[next_state] = next_dist;
                        queue.push(Reverse((next_dist, next_state)));
                    }
                }
                e = next[e];
            }
        }
        -1
    }
}
