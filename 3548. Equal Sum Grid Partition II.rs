use std::collections::HashSet;

impl Solution {
    pub fn can_partition_grid(grid: Vec<Vec<i32>>) -> bool {
        let (m, n) = (grid.len(), grid[0].len());
        let sum = grid.iter().flatten()
            .map(|&x| x as i64).sum::<i64>();
        if m == 1 || n == 1 {
            Self::check_linear(grid.iter().flatten()
                .map(|&x| x as i64), sum)
        }
        else {
            Self::check_rect(grid.iter()
                .map(|row| row.iter()
                    .map(|&x| x as i64)), sum)
            || Self::check_rect(grid.iter().rev()
                .map(|row| row.iter()
                    .map(|&x| x as i64)), sum)
            || Self::check_rect((0..n)
                .map(|j| grid.iter()
                    .map(move |row| row[j] as i64)), sum)
            || Self::check_rect((0..n).rev()
                .map(|j| grid.iter()
                    .map(move |row| row[j] as i64)), sum)
        }
    }

    fn check_linear(mut iter: impl DoubleEndedIterator<Item=i64>,
    sum: i64) -> bool {
        let first = iter.next().unwrap();
        let last = iter.next_back().unwrap();
        if first * 2 == sum || last * 2 == sum {
            return true;
        }
        let mut acc = first;
        let mut prev = first;
        let mut hi = first.max(last);
        for x in iter {
            let diff = acc * 2 - sum;
            if diff == 0
            || diff == first
            || diff == prev
            || diff == -x
            || diff == -last {
                return true;
            }
            if diff > hi {
                return false;
            }
            acc += x;
            prev = x;
            hi = hi.max(x);
        }
        let diff = acc * 2 - sum;
        if diff == 0
        || diff == first
        || diff == prev {
            return true;
        }
        false
    }

    fn check_rect(mut iter: impl Iterator<Item=impl DoubleEndedIterator<Item=i64>>,
    sum: i64) -> bool {
        let mut iter2 = iter.next().unwrap();
        let first = iter2.next().unwrap();
        let last = iter2.next_back().unwrap();
        let mut hash = HashSet::<i64>::new();
        hash.insert(0);
        hash.insert(first);
        hash.insert(last);
        let mut acc = first + last;
        let mut hi = first.max(last);
        for x in iter2 {
            acc += x;
            hash.insert(x);
            hi = hi.max(x);
        }
        let diff = acc * 2 - sum;
        if diff == 0 || diff == first || diff == last {
            return true;
        }
        
        for iter2 in iter {
            for x in iter2 {
                acc += x;
                hash.insert(x);
                hi = hi.max(x);
            }
            let diff = acc * 2 - sum;
            if hash.contains(&diff) {
                return true;
            }
            if diff > hi {
                break;
            }
        }
        false
    }
}
