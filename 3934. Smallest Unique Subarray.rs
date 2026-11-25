impl Solution {
    pub fn smallest_unique_subarray(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        if n <= 1 {
            return n as i32;
        }

        const BASE: u64 = 1_000_000_007;
        let to_u64 = |x: i32| (x as i64 - i32::MIN as i64) as u64 + 1;

        let mut hashes = Vec::with_capacity(n);
        let (mut l, mut r) = (1, n);

        while l < r {
            let k = l+(r-l)/2;

            let high_pow = BASE.wrapping_pow((k-1) as u32);

            let mut hash: u64 = 0;
            for &x in &nums[..k] {
                hash = hash.wrapping_mul(BASE).wrapping_add(to_u64(x));
            }

            hashes.clear();
            hashes.push(hash);

            for i in k..n {
                let outgoing = to_u64(nums[i-k]);
                let incoming = to_u64(nums[i]);
                hash = hash
                    .wrapping_sub(outgoing.wrapping_mul(high_pow))
                    .wrapping_mul(BASE)
                    .wrapping_add(incoming);
                hashes.push(hash);
            }

            hashes.sort_unstable();

            let m = hashes.len();
            let has_unique = (0..m).any(|i| { (i==0 || hashes[i]!=hashes[i-1]) && (i+1==m || hashes[i]!=hashes[i+1]) });

            if has_unique {
                r = k;
            } else {
                l = k+1;
            }
        }

        l as i32
    }
}
