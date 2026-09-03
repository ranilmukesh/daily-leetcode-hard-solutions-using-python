impl Solution {
    pub fn uniform_array(nums1: Vec<i32>) -> bool {
        let mut smallest = nums1[0];
        let mut has_odd = 0;
        let mut p = [0, 0];
        for v in nums1 {
            p[0] = smallest;
            p[1] = v;
            smallest = p[(1 + ((p[0] - p[1]) >> 31)) as usize];
            has_odd |= v & 1;
        }
        (smallest & 1) | (has_odd ^ 1) == 1
    }
}
