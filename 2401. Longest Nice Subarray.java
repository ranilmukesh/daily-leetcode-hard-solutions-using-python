class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitMask = 0, maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
           
            while ((bitMask & nums[right]) != 0) {
                bitMask ^= nums[left]; 
                left++; 
            }
            
            bitMask |= nums[right];
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
