const MOD: i64 = 1_000_000_007;

impl Solution {
    pub fn num_of_ways(nums: Vec<i32>) -> i32 {
        let n = nums.len();
        let mut prev = vec![0; n + 2]; 
        let mut next = vec![0; n + 2];
        let mut size = vec![0; n + 2];
        for i in 0..n + 2 {
            prev[i] = i - 1;
            next[i] = i + 1;
        }
        let mut prod = 1;

        for x in nums.into_iter().rev() {
            let x = x as usize;
            size[x] = 1;

            let left = prev[x];
            if size[left] > 0 {
                size[x] += size[left];
                let pl = prev[left];
                prev[x] = pl;
                next[pl] = x;
            }

            let right = next[x];
            if size[right] > 0 {
                size[x] += size[right];
                let nr = next[right];
                prev[nr] = x;
                next[x] = nr;
            }

            prod = prod * size[x] as i64 % MOD;
        }

        let mut fac = 1;
        for i in 2..n + 1 {
            fac = fac * i as i64 % MOD;
        }

        ((fac * Self::qpow(prod, MOD as i32 - 2) - 1 + MOD) % MOD) as _ // +MOD 保证结果非负
    }

    fn qpow(mut x: i64, mut n: i32) -> i64 {
        let mut res = 1;
        while n > 0 {
            if n % 2 > 0 {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n /= 2;
        }
        res
    }
}
