

pub trait Repeatable<T, I: Iterator<Item = T>> {
    fn repeaterator(self) -> Repeaterator<T, I>;
}

impl<T: PartialEq, I: Iterator<Item = T>> Repeatable<T, I> for I {
    fn repeaterator(self) -> Repeaterator<T, I> {
        Repeaterator::new(self)
    }
}

pub struct Repeaterator<T, I: Iterator<Item = T>> {
    iter: Peekable<I>,
}

impl<T: PartialEq, I: Iterator<Item = T>> Repeaterator<T, I> {
    pub fn new(iter: I) -> Self {
        Self {
            iter: iter.peekable(),
        }
    }
}

impl<T: PartialEq, I: Iterator<Item = T>> Iterator for Repeaterator<T, I> {
    type Item = (usize, T);

    fn next(&mut self) -> Option<Self::Item> {
        let base = self.iter.next()?;
        let mut count = 1;
        while self.iter.peek().is_some_and(|e| &base == e) {
            self.iter.next();
            count += 1;
        }
        Some((count, base))
    }
}


impl Solution {
    pub fn max_active_sections_after_trade(s: String) -> i32 {
        let len = s.len();
        let s = s.trim_start_matches('1').trim_end_matches('1');
        if s.is_empty() {
            return len as i32;
        }
        let mut count = len - s.len();
        let mut iter = s.as_bytes().iter().repeaterator();
        let mut best = 0;
        let mut left = iter.next().unwrap();
        while let Some((ones, _)) = iter.next() {
            count += ones;
            let right = iter.next().unwrap();
            best = best.max(left.0 + right.0);
            left = right;
        }
        count as i32 + best as i32
    }
}
use std::iter::Peekable;
