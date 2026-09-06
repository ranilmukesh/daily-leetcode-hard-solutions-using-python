impl Solution {
    pub fn num_distinct(s: String, t: String) -> i32 {
        let s = s.into_bytes();
        let t = t.into_bytes();
        let Some(delta) = s.len().checked_sub(t.len())
        else {
            return 0
        };
        let mut count = vec![0; delta + 1];
        count[0] = 1;
        let mut swap = Vec::with_capacity(delta + 1);
        for (i, tc) in t.into_iter().enumerate() {
            // println!("{count:?}");
            // print!("{tc:?}: ");
            let prev_count = count;
            count = swap;
            for (j, sc) in s[i .. i + (delta + 1)].iter().copied().enumerate() {
                count.push(if sc == tc {
                    prev_count[..j + 1].iter().sum()
                } else { 0 });
            }
            swap = prev_count;
            swap.clear();
        }
        // println!("{count:?}");
        count.into_iter().sum()
    }
}
