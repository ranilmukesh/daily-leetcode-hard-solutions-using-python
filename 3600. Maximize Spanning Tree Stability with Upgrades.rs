impl Solution {
    pub fn max_stability(n: i32, edges: Vec<Vec<i32>>, k: i32) -> i32 {
        #[derive(Clone, Copy)]
        struct E {
            u: u32,
            v: u32,
            s: u32,
            must: bool,
        }

        struct Dsu {
            p: Vec<u32>,
            sz: Vec<u32>,
        }
        impl Dsu {
            #[inline(always)]
            fn new(n: usize) -> Self {
                let mut p = Vec::with_capacity(n);
                let mut sz = Vec::with_capacity(n);
                for i in 0..n as u32 {
                    p.push(i);
                    sz.push(1);
                }
                Self { p, sz }
            }
            #[inline(always)]
            fn find(&mut self, mut x: u32) -> u32 {
                unsafe {
                    while *self.p.get_unchecked(x as usize) != x {
                        let px = *self.p.get_unchecked(x as usize);
                        let ppx = *self.p.get_unchecked(px as usize);
                        *self.p.get_unchecked_mut(x as usize) = ppx;
                        x = px;
                    }
                }
                x
            }
            #[inline(always)]
            fn union(&mut self, a: u32, b: u32) -> bool {
                let mut ra = self.find(a);
                let mut rb = self.find(b);
                if ra == rb {
                    return false;
                }
                unsafe {
                    if *self.sz.get_unchecked(ra as usize) < *self.sz.get_unchecked(rb as usize) {
                        core::mem::swap(&mut ra, &mut rb);
                    }
                    *self.p.get_unchecked_mut(rb as usize) = ra;
                    *self.sz.get_unchecked_mut(ra as usize) += *self.sz.get_unchecked(rb as usize);
                }
                true
            }
            #[inline(always)]
            fn count_components(&mut self) -> usize {
                let n = self.p.len();
                let mut c = 0usize;
                for i in 0..n {
                    let r = self.find(i as u32);
                    if r == i as u32 {
                        c += 1;
                    }
                }
                c
            }
        }

        let n = n as usize;
        if n <= 1 {
            return 0;
        }
        let k = k as i64;

        let mut es: Vec<E> = Vec::with_capacity(edges.len());
        for e in edges {
            unsafe {
                es.push(E {
                    u: *e.get_unchecked(0) as u32,
                    v: *e.get_unchecked(1) as u32,
                    s: *e.get_unchecked(2) as u32,
                    must: *e.get_unchecked(3) != 0,
                });
            }
        }

        {
            let mut d = Dsu::new(n);
            for &e in &es {
                if e.must && !d.union(e.u, e.v) {
                    return -1;
                }
            }
        }

        #[inline(always)]
        fn feasible(n: usize, es: &[E], k: i64, t: u32) -> bool {
            let mut d = Dsu::new(n);

            for &e in es {
                if e.must {
                    if e.s < t {
                        return false;
                    }
                    if !d.union(e.u, e.v) {
                        return false;
                    }
                }
            }

            for &e in es {
                if !e.must && e.s >= t {
                    d.union(e.u, e.v);
                }
            }

            let comps = d.count_components();
            if comps == 1 {
                return true;
            }
            let need_up = comps as i64 - 1;
            if need_up > k {
                return false;
            }

            for &e in es {
                if !e.must {
                    if e.s < t && (e.s << 1) >= t {
                        d.union(e.u, e.v);
                    }
                }
            }

            d.count_components() == 1
        }

        let mut lo: u32 = 1;
        let mut hi: u32 = 200_000;
        let mut ans: i32 = -1;

        while lo <= hi {
            let mid = lo + ((hi - lo) >> 1);
            if feasible(n, &es, k, mid) {
                ans = mid as i32;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        ans
    }
}
