struct FenwickTree {
    tree: Vec<i32>,
}

impl FenwickTree {
    fn new(size: usize) -> Self {
        Self { tree: vec![0; size] }
    }

    fn add(&mut self, mut idx: usize, val: i32) {
        while idx < self.tree.len() {
            self.tree[idx] += val;
            idx += idx & (!idx + 1);
        }
    }

    fn query(&self, mut idx: usize) -> i32 {
        let mut sum = 0;
        while idx > 0 {
            sum += self.tree[idx];
            idx -= idx & (!idx + 1);
        }
        sum
    }
}

impl Solution {
    pub fn count_majority_subarrays(nums: Vec<i32>, target: i32) -> i32 {
        let n = nums.len();
        let offset = (n + 2) as i32;
        let mut bit = FenwickTree::new(2*n + 5);
        let mut balance: i32 = 0; let mut ans = 0;
        
        bit.add(offset as usize, 1);
        for num in nums {
            balance += if num == target { 1 } else { -1 };
            let query_idx = (offset + balance - 1) as usize;
            ans += bit.query(query_idx);
            bit.add((offset + balance) as usize, 1);
        }
        ans
    }
}
