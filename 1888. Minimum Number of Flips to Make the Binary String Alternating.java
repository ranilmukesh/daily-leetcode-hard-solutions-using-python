impl Solution {
    pub fn min_flips(s: String) -> i32 {
        let n = s.len();
        // Work on doubled string
        let doubled: Vec<u8> = s.bytes().chain(s.bytes()).collect();
        let len2 = doubled.len();

        // For each position in doubled string, mismatch with pattern "010101..."
        // and with pattern "101010..."
        // Pattern 0 expected: 0 at even, 1 at odd -> expected = i%2
        // Pattern 1 expected: 1 at even, 0 at odd -> expected = (i+1)%2

        let mut mismatch0 = 0i32; // mismatches with pattern starting with 0
        let mut mismatch1 = 0i32; // mismatches with pattern starting with 1
        let mut ans = i32::MAX;

        // Initialize window [0..n)
        for i in 0..n.min(len2) {
            let b = if doubled[i] == b'1' { 1 } else { 0 };
            let exp0 = (i % 2) as i32; // 0101...
            let exp1 = ((i + 1) % 2) as i32; // 1010...
            if b != exp0 { mismatch0 += 1; }
            if b != exp1 { mismatch1 += 1; }
        }
        ans = ans.min(mismatch0.min(mismatch1));

        // Slide window
        for i in n..len2 {
            // Add new element at i
            let b_new = if doubled[i] == b'1' { 1 } else { 0 };
            let exp0_new = (i % 2) as i32;
            let exp1_new = ((i + 1) % 2) as i32;
            if b_new != exp0_new { mismatch0 += 1; }
            if b_new != exp1_new { mismatch1 += 1; }

            // Remove element at i-n
            let remove = i - n;
            let b_old = if doubled[remove] == b'1' { 1 } else { 0 };
            let exp0_old = (remove % 2) as i32;
            let exp1_old = ((remove + 1) % 2) as i32;
            if b_old != exp0_old { mismatch0 -= 1; }
            if b_old != exp1_old { mismatch1 -= 1; }

            ans = ans.min(mismatch0.min(mismatch1));
        }

        ans
    }
}
