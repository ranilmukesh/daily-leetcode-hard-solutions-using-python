impl Solution {
    pub fn get_common(nums1: Vec<i32>, nums2: Vec<i32>) -> i32 
    {
        let (mut first, mut second) = (0, 0);
        while first < nums1.len() && second < nums2.len()
        {
            if nums1[first] < nums2[second]
            {
                first +=1;
            }
            else if nums1[first] > nums2[second]
            {
                second +=1;
            }
            else
            {
                return nums1[first];
            }
        }    
        -1
    }
}
