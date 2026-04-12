impl Solution {
    pub fn minimum_distance(word: String) -> i32 {
        let word: Vec<usize> = word.bytes().map(|c| (c - b'A') as usize).collect();
        let mut dp = vec![0; 26];

        for i in 1..word.len() {
            let prev = word[i - 1];
            let cur = word[i];
            let cost = DIST_LU[prev][cur];
            let mut new_dp = dp.clone();
            for j in 0..26 {
                new_dp[prev] = new_dp[prev].max(dp[j] + cost - DIST_LU[j][cur]);
            }
            dp = new_dp;
        }

        let same_fig: i32 = word.windows(2).map(|w| DIST_LU[w[0]][w[1]]).sum();
        same_fig - dp.iter().max().unwrap()
    }
}

const fn dist(a: i32, b: i32) -> i32 {
    let xa = a / 6; let ya = a % 6;
    let xb = b / 6; let yb = b % 6;
    (xa - xb).abs() + (ya - yb).abs()
}

const fn build_dist() -> [[i32; 26]; 26] {
    let mut table = [[0_i32; 26]; 26];
    let mut i = 0;
    while i < 26 {
        let mut j = 0;
        while j < 26 { table[i][j] = dist(i as i32, j as i32); j += 1; }
        i += 1;
    }
    table
}

static DIST_LU: [[i32; 26]; 26] = build_dist();
