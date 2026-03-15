const MOD: i64 = 1_000_000_007;

pub struct Fancy {
    seq: Vec<i64>,
    mult: i64,
    add: i64,
}

impl Fancy {
    pub fn new() -> Self {
        Fancy { seq: Vec::new(), mult: 1, add: 0 }
    }

    pub fn append(&mut self, val: i32) {
        // store = (val - add) * inv(mult)
        let base = (val as i64 - self.add + MOD) % MOD * Self::pow_mod(self.mult, MOD - 2) % MOD;
        self.seq.push(base);
    }

    pub fn add_all(&mut self, inc: i32) {
        self.add = (self.add + inc as i64) % MOD;
    }

    pub fn mult_all(&mut self, m: i32) {
        self.mult = self.mult * m as i64 % MOD;
        self.add = self.add * m as i64 % MOD;
    }

    pub fn get_index(&self, idx: i32) -> i32 {
        let idx = idx as usize;
        if idx >= self.seq.len() { return -1; }
        ((self.seq[idx] * self.mult + self.add) % MOD) as i32
    }

    fn pow_mod(mut base: i64, mut exp: i64) -> i64 {
        let mut result = 1i64;
        base %= MOD;
        while exp > 0 {
            if exp & 1 == 1 { result = result * base % MOD; }
            exp >>= 1;
            base = base * base % MOD;
        }
        result
    }
}
