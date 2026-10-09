impl Solution {
	pub fn min_insertions(s: String) -> i32 {
        let mut it = s.bytes().peekable();
        let mut st = 0;
        let mut ans = 0;
        while let Some(c) = it.next() {
            match c {
                b'(' => st += 1,
                _ /* b')'*/ => {
                    if it.next_if(|c| *c == b')').is_none() {
                        ans += 1;
                    }
                    match st {
                        0 => ans += 1,
                        _ => st -= 1,
                    }
                }
            }
        }
        ans + st * 2
    }
}
