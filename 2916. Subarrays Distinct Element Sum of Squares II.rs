const MOD: i64 = 1_000_000_000 + 7;

impl Solution {
    pub fn sum_counts(nums: Vec<i32>) -> i32 {
        let last_seen = &mut [u32::MAX; 100_001];
        let mut range_tree = RangeFenwick::new(nums.len());
        let mut sq = 0_i64;
        nums.iter()
            .enumerate()
            .map(|(right, &x)| {
                let x = x as usize;
                let prev = last_seen[x];
                last_seen[x] = right as u32;
                (right, prev.wrapping_add(1) as usize)
            })
            .fold(0, |all_sums_squares, (right, left)| {
                let s = range_tree.range_sum(left, right);
                range_tree.add(left, right + 1, 1);
                let len = right - left + 1;
                sq += 2 * s + len as i64;

                (all_sums_squares + sq) % MOD
            }) as i32
    }
}

struct RangeFenwick {
    n: usize,
    /// difference diff[k]
    b1: FenwickTree,
    /// stores diff[k] * k
    b2: FenwickTree,
}

impl RangeFenwick {
    /// Starts as all zeros.
    fn new(n: usize) -> Self {
        RangeFenwick {
            n,
            b1: FenwickTree::new(n),
            b2: FenwickTree::new(n),
        }
    }

    /// Add `delta` to every element in `l..r`.
    fn add(&mut self, l: usize, r: usize, delta: i64) {
        self.b1.add(l, delta);
        self.b2.add(l, delta * l as i64);
        self.b1.add(r, -delta);
        self.b2.add(r, -delta * r as i64);
    }

    /// Sum of elements in [0, p).
    pub fn prefix_sum(&self, p: usize) -> i64 {
        p as i64 * self.b1.prefix_sum(p) - self.b2.prefix_sum(p)
    }

    /// Sum of elements in [l, r).
    pub fn range_sum(&self, l: usize, r: usize) -> i64 {
        self.prefix_sum(r) - self.prefix_sum(l)
    }
}

pub struct FenwickTree {
    // 1-indexed
    tree: Vec<i64>,
}

impl FenwickTree {
    /// Create a tree of size `n`, all zeros.
    pub fn new(n: usize) -> Self {
        FenwickTree {
            tree: vec![0; n + 1],
        }
    }

    /// Add `delta` to the element at 0-based index `i`.
    pub fn add(&mut self, i: usize, delta: i64) {
        let mut i = i + 1;
        while i < self.tree.len() {
            self.tree[i] += delta;
            i += lowbit(i);
        }
    }

    /// Sum of elements in `0..i`
    pub fn prefix_sum(&self, mut i: usize) -> i64 {
        let mut sum = 0;
        while i > 0 {
            sum += self.tree[i];
            i -= lowbit(i);
        }
        sum
    }

    /// Sum of elements in `l..r`
    pub fn range_sum(&self, l: usize, r: usize) -> i64 {
        self.prefix_sum(r) - self.prefix_sum(l)
    }
}

/// Computes the lowest set bit in the `i`.
///
/// Equivalent to `1 << i.trailing_zeros()`.
fn lowbit(i: usize) -> usize {
    // i & -i
    i & i.wrapping_neg()
}
