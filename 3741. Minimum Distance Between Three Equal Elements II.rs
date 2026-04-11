use std::collections::HashMap;

impl Solution {
    pub fn minimum_distance(nums: Vec<i32>) -> i32 {
        nums.iter()
            .enumerate()
            .fold(HashMap::<i32, Vec<usize>>::new(), |mut m, (i, &x)| {
                m.entry(x).or_default().push(i);
                m
            })
            .values()
            .flat_map(|v| {
                v.windows(3)
                    .map(|x| 2 * i32::try_from(x[2] - x[0]).unwrap())
            })
            .min()
            .unwrap_or(-1)
    }
}
