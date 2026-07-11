impl Solution {
    pub fn count_complete_components(mut n: i32, a: Vec<Vec<i32>>) -> i32 {
        let mut p = [2500; 50];
        fn f(p: &mut [i32], x: usize) -> usize {
            if p[x] > 0 { x } else {
                let y = f(p, !p[x] as _);
                p[x] = !y as _;
                y
            }
        }
        for e in a {
            let x = f(&mut p, e[0] as _);
            let y = f(&mut p, e[1] as _);
            if x != y {
                p[y] += p[x];
                p[x] = !y as _
            }
            p[y] += 2
        }
        for x in p {
            if x % (2499 + x / 2500) != 0 {
                n -= 1
            }
        }
        n
    }
}
