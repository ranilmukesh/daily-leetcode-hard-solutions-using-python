class Solution {
    public int longestSubarray(int[] nums) {
        int len = 1;
         
        int max = Integer.MIN_VALUE;
        for (int num : nums){
            max = Math.max(max, num);
        } 

        int tmp_len = 0;
        for(int num: nums){
            if(num == max){
                tmp_len ++;
            }
            else{
                len = Math.max(len,tmp_len);
                tmp_len = 0;
            }
        }
        len = Math.max(len,tmp_len);
        return len;
    }
}
