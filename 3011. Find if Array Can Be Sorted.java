class Solution {
    public boolean canSortArray(int[] nums) {
        int max=nums[0];
        int bits = countBits(nums[0]);
        int lastMax=0;
        for(int i=1; i<nums.length; i++) {
            boolean changeBits = bits !=countBits(nums[i]);
            if(changeBits) lastMax=max;                
            if(nums[i]>max) {
                max = nums[i];
                bits = countBits(max);
            }
            if(nums[i]<lastMax)return false;
        }
        return true;
    }
    private int countBits(int n) {
        int count =0;
        while(n>0) {
            count +=n&1;
            n=n>>1;
        }
        return count;
    }
}
