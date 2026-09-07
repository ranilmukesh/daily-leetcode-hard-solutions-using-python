impl Solution {
    pub fn distinct_subseq_ii(s: String) -> i32 {
        let MOD = 1e9 as i32 + 7;
        let mut dp: Vec<i32> = vec![0; 26];
        let mut ans = 1;

        for c in s.as_bytes() {
            let c = (c - b'a') as usize;
            let tp = ans;
            ans = ans * 2;
            if ans >= MOD { ans -= MOD; }
            ans -= dp[c];
            if ans < 0 { ans += MOD; }
            dp[c] = tp;
        }
        if ans == 0 { MOD - 1} else { ans - 1 }
    }
}
