struct Ctx {
    cnt: Vec<i64>,
    k: i64,
    ans: i64,
}
impl Ctx {
    fn new(nums1: Vec<i32>, nums2: Vec<i32>, k1: i32, k2: i32) -> Self {
        let mut cnt = vec![0; 100001];
        for i in 0..nums1.len() {
            let d = (nums1[i] - nums2[i]).abs() as usize;
            cnt[d] += 1;
        }
        Self {
            cnt,
            k: (k1 + k2) as i64,
            ans: 0,
        }
    }
}
struct Eng;
impl Eng {
    fn run(ctx: &mut Ctx) {
        let mut sum = 0i64;
        for i in 0..ctx.cnt.len() {
            sum += ctx.cnt[i] * i as i64;
        }
        if sum <= ctx.k {
            return;
        }
        let mut cur = ctx.cnt.len() - 1;
        while ctx.k > 0 && cur > 0 {
            if ctx.cnt[cur] == 0 {
                cur -= 1;
                continue;
            }
            let nxt = cur - 1;
            let mv = (ctx.cnt[cur]).min(ctx.k);
            let need = mv;
            ctx.cnt[cur] -= mv;
            ctx.cnt[nxt] += mv;
            ctx.k -= need;
        }
        for i in 0..ctx.cnt.len() {
            ctx.ans += ctx.cnt[i] * (i as i64) * (i as i64);
        }
    }
}
struct Svc {
    ctx: Ctx,
}
impl Svc {
    fn new(nums1: Vec<i32>, nums2: Vec<i32>, k1: i32, k2: i32) -> Self {
        Self {
            ctx: Ctx::new(nums1, nums2, k1, k2),
        }
    }
    fn run(&mut self) -> i64 {
        Eng::run(&mut self.ctx);
        self.ctx.ans
    }
}
impl Solution {
    pub fn min_sum_square_diff(nums1: Vec<i32>, nums2: Vec<i32>, k1: i32, k2: i32) -> i64 {
        let mut svc = Svc::new(nums1, nums2, k1, k2);
        svc.run()
    }
}
