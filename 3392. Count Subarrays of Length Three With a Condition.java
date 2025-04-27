class Solution {
    public int countSubarrays(int[] nums) {
        int count = 0;
        for(int i =2;i<nums.length;i++){
            int x = (nums[i]+nums[i-2])*2;
            if(x == nums[i-1])count++;
        }
        return count;
    }
}
