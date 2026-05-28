#[derive(Clone, Copy)]
struct Node {
    next: [u32; 26],
    best: u32,
}

impl Node {
    #[inline(always)]
    fn new(best: u32) -> Self {
        Self {
            next: [0; 26],
            best,
        }
    }
}

impl Solution {
    pub fn string_indices(words_container: Vec<String>, words_query: Vec<String>,
    ) -> Vec<i32> {
        let n = words_container.len();
        let lens: Vec<usize> = words_container.iter().map(|s| s.len()).collect();
        let mut root_best = 0usize;
        for i in 1..n {
            if lens[i] < lens[root_best] {
                root_best = i;
            }
        }
        let total_chars: usize = lens.iter().sum();
        let mut trie = Vec::<Node>::with_capacity(total_chars + 1);
        trie.push(Node::new(root_best as u32));
        for (idx, word) in words_container.iter().enumerate() {
            let mut curr = 0usize;
            let bytes = word.as_bytes();
            for i in (0..bytes.len()).rev() {
                let c = (bytes[i] - b'a') as usize;
                let next = trie[curr].next[c];
                if next == 0 {
                    trie[curr].next[c] = trie.len() as u32;
                    trie.push(Node::new(idx as u32));
                    curr = trie.len() - 1;
                } else {
                    curr = next as usize;
                    let best_idx = trie[curr].best as usize;
                    if lens[idx] < lens[best_idx] {
                        trie[curr].best = idx as u32;
                    }
                }
            }
        }
        let mut ans = Vec::with_capacity(words_query.len());
        for word in words_query {
            let mut curr = 0usize;
            let bytes = word.as_bytes();
            for i in (0..bytes.len()).rev() {
                let c = (bytes[i] - b'a') as usize;
                let next = trie[curr].next[c];
                if next == 0 {
                    break;
                }
                curr = next as usize;
            }
            ans.push(trie[curr].best as i32);
        }
        ans
    }
}
