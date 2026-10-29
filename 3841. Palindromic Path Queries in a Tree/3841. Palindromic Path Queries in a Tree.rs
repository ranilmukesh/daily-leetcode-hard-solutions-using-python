impl Solution {
    pub fn palindrome_path(
        n: i32,
        edges: Vec<Vec<i32>>,
        s: String,
        queries: Vec<String>,
    ) -> Vec<bool> {
        let tree = Tree::new(n as usize, edges);
        let mut tree_with_xor = TreeWithRangeXor::new(tree, s.into_bytes());

        let mut ans = Vec::with_capacity(queries.len());
        queries.iter().for_each(|q| {
            if let Some(s) = q.strip_prefix("update ") {
                let mut iter = s.split_ascii_whitespace();
                let node: usize = iter.next().unwrap().parse().unwrap();
                let char_replacement = iter.next().unwrap().as_bytes()[0];

                tree_with_xor.update(node, char_replacement);
            } else {
                let s = q.strip_prefix("query ").unwrap();
                let mut iter = s.split_ascii_whitespace();
                let node1: usize = iter.next().unwrap().parse().unwrap();
                let node2: usize = iter.next().unwrap().parse().unwrap();

                ans.push(tree_with_xor.query(node1, node2));
            }
        });

        ans
    }
}

struct TreeWithRangeXor {
    tree: Tree,
    rangexor: FenwickTree,
    /// `letter_idx[u]`: a letter index to track path XOR
    letter_idx: Vec<u8>,
}

impl TreeWithRangeXor {
    fn new(tree: Tree, letters: Vec<u8>) -> Self {
        let n = letters.len();
        let letter_idx: Vec<u8> = letters.iter().map(|&c| c - b'a').collect();
        let mut rangexor = FenwickTree::new(n);
        tree.dfs_entrance
            .iter()
            .zip(tree.dfs_exit.iter().zip(letter_idx.iter()))
            .for_each(|(&entrance, (&exit, &letter_bit_idx))| {
                rangexor.range_xor(entrance as usize, exit as usize, 1 << letter_bit_idx);
            });

        Self {
            tree,
            rangexor,
            letter_idx,
        }
    }

    fn get_path_to_root(&self, node: usize) -> u32 {
        self.rangexor.point(self.tree.dfs_entrance[node] as usize)
    }

    fn update(&mut self, node: usize, new_char: u8) {
        let new_idx = new_char - b'a';
        let delta = (1 << self.letter_idx[node]) ^ (1 << new_idx);
        self.letter_idx[node] = new_idx;
        if delta != 0 {
            self.rangexor.range_xor(
                self.tree.dfs_entrance[node] as usize,
                self.tree.dfs_exit[node] as usize,
                delta,
            );
        }
    }

    fn query(&self, node1: usize, node2: usize) -> bool {
        let mask = self.get_path_to_root(node1)
            ^ self.get_path_to_root(node2)
            ^ (1 << self.letter_idx[self.tree.lca(node1, node2) as usize]);
        mask.count_ones() <= 1
    }
}

struct Tree {
    /// `parent[u]` is a parent for node `u`
    parent: Vec<u16>,
    /// `dfs_entrance[u]`: the first time we enter subtree of `u` with dfs
    dfs_entrance: Vec<u16>,
    /// `dfs_exit[u]`: the index of the last node in the subtree visited with dfs.
    dfs_exit: Vec<u16>,
    /// `order[dfs_order]`: the node id
    order: Vec<u16>,
    /// A sparse table to find LCA.
    first: Vec<Vec<u16>>,
}

impl Tree {
    fn new(n: usize, edges: Vec<Vec<i32>>) -> Self {
        let mut adjacency_list = vec![Vec::new(); n];
        edges.iter().for_each(|e| {
            let &[a, b] = e.as_slice() else {
                unreachable!()
            };
            let (a, b) = (a as u16, b as u16);
            adjacency_list[a as usize].push(b);
            adjacency_list[b as usize].push(a);
        });
        // root's parent is itself, so `position()` always finds a parent
        adjacency_list[0].push(0); 

        let mut parent = vec![0_u16; n];
        let mut dfs_entrance = vec![0_u16; n];
        let mut dfs_exit = vec![0_u16; n];
        let mut order = Vec::with_capacity(n);

        let mut stack = vec![0_u32];

        while let Some(x) = stack.pop() {
            if x as usize >= n {
                dfs_exit[(!x) as usize] = order.len() as u16;
                continue;
            }

            dfs_entrance[x as usize] = order.len() as u16;
            order.push(x as u16);
            stack.push(!x);
            let adj_of_x = &adjacency_list[x as usize];
            let parent_idx = adj_of_x
                .iter()
                .position(|&maybe_parent| maybe_parent == parent[x as usize])
                .unwrap();
            adj_of_x[..parent_idx]
                .iter()
                .chain(adj_of_x[parent_idx + 1..].iter())
                .for_each(|&child| {
                    parent[child as usize] = x as u16;
                    stack.push(child as u32);
                })
        }

        let very_first: Vec<u16> = order
            .iter()
            .map(|&x| dfs_entrance[parent[x as usize] as usize])
            .collect();
        let mut first = vec![very_first];
        (1..bit_width(n)).for_each(|k| {
            let prev = first.last().unwrap();
            let step = 1 << (k - 1);
            let next = prev
                .iter()
                .zip(prev.iter().skip(step))
                .map(|(&a, &b)| a.min(b))
                .collect();
            first.push(next);
        });

        Self {
            parent,
            dfs_entrance,
            dfs_exit,
            order,
            first,
        }
    }

    fn lca(&self, node1: usize, node2: usize) -> u16 {
        if node1 == node2 {
            return node1 as u16;
        }

        let (a, b) = (self.dfs_entrance[node1], self.dfs_entrance[node2]);
        let smol = a.min(b) as usize;
        let big = a.max(b) as usize;
        let k: usize = (big - smol).ilog2() as usize;

        self.order[self.first[k][smol + 1].min(self.first[k][big - (1 << k) + 1]) as usize]
    }
}

struct FenwickTree {
    tree: Vec<u32>,
}

impl FenwickTree {
    fn new(n: usize) -> Self {
        FenwickTree { tree: vec![0; n] }
    }

    /// XOR `v` into difference-array slot `idx`.
    fn xor(&mut self, idx: usize, v: u32) {
        let mut i = idx;
        while i < self.tree.len() {
            self.tree[i] ^= v;
            i |= i + 1;
        }
    }

    /// XOR of difference-array slots `0..idx`.
    fn prefix_xor(&self, idx: usize) -> u32 {
        let mut i = idx;
        let mut acc = 0;
        while i > 0 {
            acc ^= self.tree[i - 1];
            i &= i - 1;
        }
        acc
    }

    /// XOR `v` onto every position in `l..r`.
    fn range_xor(&mut self, l: usize, r: usize, v: u32) {
        self.xor(l, v);
        self.xor(r, v); // no-op if r == len
    }

    /// Value at position `i`.
    fn point(&self, i: usize) -> u32 {
        self.prefix_xor(i + 1)
    }
}

fn bit_width(i: usize) -> usize {
    (usize::BITS - i.leading_zeros()) as usize
}
