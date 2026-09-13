fn find(xs: &Vec<i32>) -> i32 {
    xs.iter().fold(0, |x0,&x| (x0 << 1) | x)
}
impl Solution {
    pub fn largest_overlap(img1: Vec<Vec<i32>>, img2: Vec<Vec<i32>>) -> i32 {
        let n = img1.len();
        let xs: Vec<_> = img1.iter().map(find).collect();
        let ys: Vec<_> = img2.iter().map(find).collect();
        let mut best = 0;
        for i in 0..n {
            let xs1 = &xs[i..];
            let ys1 = &ys[i..];
            for j in 0..n {
                best = xs1.iter().zip(ys.iter()).fold(0, |x0,(x,y)| x0 + ((x >> j) & y).count_ones()).max(best);
                best = xs1.iter().zip(ys.iter()).fold(0, |x0,(x,y)| x0 + (x & (y >> j)).count_ones()).max(best);
                best = ys1.iter().zip(xs.iter()).fold(0, |x0,(x,y)| x0 + ((x >> j) & y).count_ones()).max(best);
                best = ys1.iter().zip(xs.iter()).fold(0, |x0,(x,y)| x0 + (x & (y >> j)).count_ones()).max(best);
            }
        }
        best as i32
    }
}
