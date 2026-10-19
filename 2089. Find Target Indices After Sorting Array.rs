impl Solution {
    pub fn target_indices(nums: Vec<i32>, target: i32) -> Vec<i32> {
    let mut smaller: u8 = 0;
    let mut bigger: u8= 0;
    for &i in nums.iter() {
        if i < target {
            smaller += 1;
        } else if i > target {
            bigger += 1;
        }
    }
    (smaller as i32..(nums.len() as u8 - bigger) as i32)
        .collect()
    }
}
