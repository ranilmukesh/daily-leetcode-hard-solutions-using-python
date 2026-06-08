use std::collections::VecDeque;
use std::cmp;

impl Solution {
    pub fn pivot_array(mut nums: Vec<i32>, pivot: i32) -> Vec<i32> {
        let mut answer : VecDeque<i32> = VecDeque::with_capacity(nums.len());
        let mut smaller : Vec<i32> = Vec::new();
        let mut greater : Vec<i32> = Vec::new();

        for num in nums {
            match num.cmp(&pivot) {
                std::cmp::Ordering::Less => smaller.push(num),
                std::cmp::Ordering::Equal => answer.push_front(num),
                std::cmp::Ordering::Greater => greater.push(num),
            }
        }

        for small in smaller.iter().rev() {
            answer.push_front(*small);
        }

        for great in greater.iter() {
            answer.push_back(*great);
        }

        Vec::<i32>::from(answer)
    }
}
