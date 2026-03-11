impl Solution {
    pub fn number_of_stable_arrays(zero: i32, one: i32, limit: i32) -> i32 {
        let (zero, one, limit) = (zero.min(one) as u64, zero.max(one) as u64, limit as u64);
        if limit == 1 {
            if zero == one {
                return 2;
            }
            if zero + 1 == one {
                return 1;
            }
            return 0;
        }
        let (mut result, mut prev, mut curr, mut next) = (0, 0, split_ways(one, 1, limit), split_ways(one, 2, limit));
        for k in 1..=zero {
            result = (result + (prev + 2*curr + next) * split_ways(zero, k, limit)) % MOD;
            (prev, curr, next) = (curr, next, split_ways(one, k + 2, limit));
        }
        result as i32
    }
}

const MOD: u64 = 1_000_000_007;
const N: usize = 2001;

const fn precalc() -> ([u64; N], [u64; N]) {
    let mut fact = [1u64; N];
    let mut inv_fact = [1u64; N];
    let mut i = 2;
    while i < N {
        fact[i] = (fact[i - 1] * i as u64) % MOD;
        i += 1;
    }
    inv_fact[N - 1] = mod_pow(fact[N - 1], MOD - 2);
    let mut i = N - 1;
    while i > 1 {
        inv_fact[i - 1] = (inv_fact[i] * i as u64) % MOD;
        i -= 1;
    }
    (fact, inv_fact)
}

const fn mod_pow(mut base: u64, mut exp: u64) -> u64 {
    let mut res = 1;
    base %= MOD;
    while exp > 0 {
        if exp % 2 == 1 {
            res = (res * base) % MOD;
        }
        base = (base * base) % MOD;
        exp /= 2;
    }
    res
}

const FACTORIALS: ([u64; N], [u64; N]) = precalc();

fn c(n: u64, r: u64) -> u64 {
    unsafe { (*FACTORIALS.0.get_unchecked(n as usize) * ((*FACTORIALS.1.get_unchecked(r as usize) * *FACTORIALS.1.get_unchecked((n - r) as usize)) % MOD)) % MOD }
}

fn split_ways(n: u64, k: u64, limit: u64) -> u64 {
    if n == k {
        return 1;
    }
    if n > k * limit {
        return 0;
    }
    let (mut total, mut flag, mut remaining, mut j) = (0i64, 1, n as i64, 0);
    while j <= k && k as i64 <= remaining {
        let t = c(k, j) * c(remaining as u64 - 1, k - 1);
        total = (((total + (MOD * MOD) as i64 + t as i64 * flag) as u64) % MOD) as i64;
        flag = -flag;
        remaining -= limit as i64;
        j += 1;
    }
    total as u64
}
