class Solution {
    public int minSwaps(int[] nums) {
        int onesCount = 0, n = nums.length;
        for(int num : nums){
            onesCount += num;
        }
        if(onesCount<2 || onesCount==n){
            return 0;
        }
        int res = 100001, zeroesCount = 0;
        for(int i=0; i<onesCount; i++){
            zeroesCount += nums[i]==0 ? 1 : 0;
        }
        res = Math.min(res, zeroesCount);
        for(int i=1; i<n; i++){
            zeroesCount -= nums[i-1]==0 ? 1 : 0;
            zeroesCount += nums[(i+onesCount-1)%n]==0 ? 1 : 0;
            res = Math.min(res, zeroesCount);
        }
        return res;
    }
}
