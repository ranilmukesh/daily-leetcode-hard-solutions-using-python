impl Solution {
    pub fn assign_edge_weights(mut edges: Vec<Vec<i32>>) -> i32 {
        if edges.len() == 1 {
            return 1;
        }
        let mut max_depth = 0;
        let mut map = vec![0; edges.len() + 2];
        edges.sort_unstable_by_key(|x| (x[0], x[1]));
        for edge_pair in edges {
            let (u, v) = (edge_pair[0], edge_pair[1]);
            let (parent, child) = (u.min(v), u.max(v));
            let depth = map[parent as usize] + 1;
            map[child as usize] = depth;
            max_depth = max_depth.max(depth);
        }

        let mut ans: i64 = 1;
        let mut base: i64 = 2;
        let mut exp = max_depth - 1;
        let modulo: i64 = 1_000_000_007;

        while exp > 0 {
            if exp % 2 == 1 {
                ans = (ans * base) % modulo;
            }
            base = (base * base) % modulo;
            exp /= 2;
        }

        ans as i32
    }
}
