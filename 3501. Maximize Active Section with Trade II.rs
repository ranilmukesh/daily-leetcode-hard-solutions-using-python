struct SegTree {
    maxima: Vec<usize>,
    intervals: Vec<(usize, usize, usize, usize)>,
    n: usize,
}

impl SegTree {
    fn new(intervals: Vec<(usize, usize, usize, usize)>) -> Self {
        //structure of intervals is (left, right, number of 1s in interval, where the 1s start)
        //this way we can reconstruct how much that interval is "worth"

        let n = intervals.len();
        let maxima = Self::generate(&intervals);

        Self {
            maxima,
            intervals,
            n
        }
    }

    fn generate(intervals: &Vec<(usize, usize, usize, usize)>) -> Vec<usize> {
        if intervals.is_empty() {
            return Vec::new();
        }
        let n = intervals.len();
        let mut maxima: Vec<usize> = vec![0; n * 4];
        Self::fill_maxima(intervals, &mut maxima, 0, n - 1, 1);
        maxima
    }

    fn fill_maxima(intervals: &Vec<(usize, usize, usize, usize)>, maxima: &mut Vec<usize>, l: usize, r: usize, pos: usize) {
        if l == r {
            let interval = intervals[l];
            maxima[pos] = interval.1  + 1 - interval.0 - interval.2;
        } else {
            let mid = (l + r) / 2;
            Self::fill_maxima(intervals, maxima, l, mid, pos * 2);
            Self::fill_maxima(intervals, maxima, mid + 1, r, pos * 2 + 1);
            maxima[pos] = std::cmp::max(maxima[pos * 2], maxima[pos * 2 + 1]);
        }
    }

    fn query(&self, start: usize, end: usize) -> usize {
        if self.intervals.is_empty() {
            return 0;
        }
        self.pull_query(start, end, 0, self.n - 1, 1)
    }

    fn pull_query(&self, start: usize, end: usize, l: usize, r: usize, pos: usize) -> usize {
        if start <= self.intervals[l].0  && self.intervals[r].1 <= end {
            return self.maxima[pos];
        }

        if self.intervals[l].0 > end || self.intervals[r].1 < start {
            //maybe possible to cull more strictly?
            return 0;
        }

        if l == r {
            if start < self.intervals[l].3 && (self.intervals[l].3 + self.intervals[l].2) <= end {
                //find the diff
                let left_diff = if self.intervals[l].0 < start {
                    start - self.intervals[l].0
                } else {
                    0
                };
                let right_diff = if end < self.intervals[l].1 {
                    self.intervals[l].1 - end
                } else {
                    0
                };
                return self.maxima[pos] - left_diff - right_diff;
            }
            return 0;
        }

        let mid = (l + r) / 2;
        std::cmp::max(
            self.pull_query(start, end, l, mid, pos * 2),
            self.pull_query(start, end, mid + 1, r, pos * 2 + 1)
        )
    }
}

impl Solution {
    pub fn max_active_sections_after_trade(s: String, queries: Vec<Vec<i32>>) -> Vec<i32> {
        //first assemble list of intervals
        let mut cur = '1';
        let original_ones = s.chars().filter(|&x| x == '1').count();
        let mut ones = 0;
        let mut zeroes = 0;
        let mut last_zeroes = 0;
        
        let mut intervals: Vec<(usize, usize, usize, usize)> = Vec::new();

        for (i, c) in s.chars().chain(['1']).enumerate() {
            if c == '1' {
                if cur == '0' {
                    //we've entered 1s from zeroes. check if the previous band is a candidate
                    if last_zeroes != 0 {
                        let left = i - last_zeroes - ones - zeroes;
                        let one_start = i - zeroes - ones;
                        intervals.push((left, i - 1, ones, one_start));
                    }
                    last_zeroes = zeroes;
                    zeroes = 0;
                    ones = 0;
                }
                ones += 1;
            } else {
                zeroes += 1;
            }
            cur = c;
        }


        let segs = SegTree::new(intervals);
        let mut ans = Vec::new();

        for query in queries {
            let (left, right) = (query[0] as usize, query[1] as usize);
            ans.push((original_ones + segs.query(left, right)) as i32);
        }
        
        ans
    }
}
