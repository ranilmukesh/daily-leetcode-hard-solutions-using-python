class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count=0;
        int r=0;
        int l=0;
        long sum=0;
        while(r<nums.length){
          sum+=nums[r];
          while((r-l+1)*sum>=k){
            sum-=nums[l];
            l++;
          }
          count+=(r-l+1);
          r++;
        }
        return count;
    }
}
