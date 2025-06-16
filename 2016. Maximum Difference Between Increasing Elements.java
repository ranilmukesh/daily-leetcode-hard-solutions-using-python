class Solution {
    public int maximumDifference(int[] nums) {
        int temp=0;
        int maxd=-1;
       int ans=nums[0];
        for(int i=1;i<nums.length;i++){
                if(nums[i]>ans){
                    temp=nums[i]-ans;
                    maxd=Math.max(maxd,temp);
                }
                else{
                    ans=nums[i];
                }
        }
        return maxd;
    }
}
