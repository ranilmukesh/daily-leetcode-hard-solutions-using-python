impl Solution {
    pub fn find_max_path_score(edges: Vec<Vec<i32>>, online: Vec<bool>, k: i64) -> i32 {
        let n = online.len();
        let mut g = vec![vec![]; n];
        let mut l = i32::MAX;
        let mut r = 0;

        for edge in &edges {
            let u = edge[0] as usize;
            let v = edge[1] as usize;
            let w = edge[2];
            if !online[u] || !online[v] {
                continue;
            }
            g[u].push((v, w as i64));
            l = l.min(w);
            r = r.max(w);
        }

        let check = |mid: i32| -> bool {
            fn dfs(u: usize, mid: i32, g: &Vec<Vec<(usize, i64)>>, memo: &mut Vec<i64>) -> i64 {
                if u == g.len() - 1 {
                    return 0;
                }
                if memo[u] != -1 {
                    return memo[u];
                }
                
                let mut res = i64::MAX / 2;
                for &(v, w) in &g[u] {
                    if w >= mid as i64 {
                        res = res.min(dfs(v, mid, g, memo) + w);
                    }
                }
                memo[u] = res;
                res
            }
            
            let mut memo = vec![-1i64; n];
            dfs(0, mid, &g, &mut memo) <= k
        };

        if !check(l) {
            return -1;
        }

        while l <= r {
            let mid = (l + r) >> 1;
            if check(mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        r
    }
}
