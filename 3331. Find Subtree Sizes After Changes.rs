// Hmm, what is the bruteforce way to do it?
// 1. Build original tree.
// 2. Build a new tree by applying the thing to original tree.
// 3. Calculate subtree sizes.
//
// But what do we actually need to do to get the last thingy?
// 1. Find lowest ancestor (la) with `s[node] = s[la]`
// 2. Remove `subtree_size(node)` from nodes in `node..la` path.
//
// That's it. Because `la` is an ancestor of a node, its subtree size doesn't change.
// And for example, that's why `root` subtree size will be `n` no matter inputs.
// Also, since we only search ancestors, we can never attach a node to a leaf,
// or to a node from different subtree.
// Thus if we process tree from leaves to root, we only ever need to process each node once.
//
// So the only real problem is finding leaves and then finding lowest ancestor with s[node]=s[la].
// I guess we can keep a `[last_seen;26]` array to track when we last seen each number;
// although storing 108 bytes array per node is a bit ugly.
impl Solution {
    pub fn find_subtree_sizes(parent: Vec<i32>, s: String) -> Vec<i32> {
        let s = s.as_bytes();
        let n = parent.len();

        // children[start[p]..start[p + 1]] are the children of p.
        let mut start = vec![0_usize; n + 1];
        parent[1..]
            .iter()
            .map(|&p| p as usize)
            .for_each(|p| start[p] += 1);
        (0..n).for_each(|idx| start[idx + 1] += start[idx]);

        let mut children = vec![0_u32; n - 1];
        parent.iter().enumerate().skip(1).for_each(|(idx, &p)| {
            let p = p as usize;
            start[p] -= 1;
            children[start[p]] = idx as u32;
        });

        let mut last_seen: Vec<[i32; 26]> = vec![[-1; 26]; n];
        last_seen[0][to_idx(s[0])] = 0;
        let mut bfs_order: Vec<u32> = Vec::with_capacity(n);
        bfs_order.push(0);
        let mut current_idx = 0;
        while current_idx < bfs_order.len() {
            let p = bfs_order[current_idx] as usize;
            current_idx += 1;
            children[start[p]..start[p + 1]].iter().for_each(|&child| {
                let child = child as usize;
                last_seen[child] = last_seen[p];
                last_seen[child][to_idx(s[child])] = child as i32;
                bfs_order.push(child as u32);
            });
        }

        let mut answer = vec![1_i32; n];
        bfs_order[1..].iter().rev().for_each(|&child| {
            let child = child as usize;
            let parent = parent[child] as usize;
            let new_parent = last_seen[parent][to_idx(s[child])];
            if new_parent >= 0 {
                answer[new_parent as usize] += answer[child];
            } else {
                answer[parent] += answer[child];
            }
        });

        answer
    }
}

fn to_idx(c: u8) -> usize {
    (c - b'a') as usize
}
