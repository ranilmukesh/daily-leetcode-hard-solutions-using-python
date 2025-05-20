class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] lambda = new int[nums.length+1];
        for(int i=0;i<queries.length;i++){
            lambda[queries[i][0]]++;
            lambda[queries[i][1]+1]--;
        }
        int add = 0;
        for(int i=0; i<nums.length; i++){
            add+=lambda[i];
            if(add<nums[i]){
                return false;
            }
        }
        return true;
    }
}
