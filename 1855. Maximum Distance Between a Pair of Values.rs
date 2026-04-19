impl Solution {
    pub fn max_distance(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 {
        let (mut left, mut right,mut result) = (0,0,0);
        while right < nums2.len() && left < nums1.len() {
            while right < nums2.len() && nums1[left] <= nums2[right] {
                result = result.max(right-left);
                right += 1;
            }
            left += 1;
            right = right.max(left);            
        }
        result as i32
    }
}
