class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] rec = new boolean[101];
        int n=nums.length;
        int lastIdx = -1;
        for(int i=n-1;i>=0;i--){
            if(rec[nums[i]]){
                lastIdx = i;
                break;
            }
            rec[nums[i]] = true;
        }
        return lastIdx == -1 ? 0 : (lastIdx+3)/3;
    }
}
