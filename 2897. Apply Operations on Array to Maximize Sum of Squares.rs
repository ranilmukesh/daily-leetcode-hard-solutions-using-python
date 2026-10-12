impl Solution {
    pub fn max_sum(nums: Vec<i32>, k: i32) -> i32 {
        const MOD: i64 = 1_000_000_007;
        let mut counts = [0usize; 30];

        for num in nums {
            let mut bits = num as u32;
            while bits != 0 {
                counts[bits.trailing_zeros() as usize] += 1;
                bits &= bits - 1;
            }
        }

        let mut answer = 0i64;
        for i in 0..k as usize {
            let mut value = 0i64;
            for (bit, &count) in counts.iter().enumerate() {
                if count > i {
                    value |= 1i64 << bit;
                }
            }
            if value == 0 {
                break;
            }
            answer = (answer + value * value) % MOD;
        }

        answer as i32
    }
}
