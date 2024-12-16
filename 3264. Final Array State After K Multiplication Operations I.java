class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int i=0;
        int j=0;
        int min=0;
        int l=0;
        while(i<k){
            min=nums[0];
            l=0;
            for(j=0;j<nums.length;j++){
                if(nums[j]<min){
                    min=nums[j];
                    l=j;
                }
            }
            nums[l]=min*multiplier;
            i++;
        }
        return nums;
    }
}
