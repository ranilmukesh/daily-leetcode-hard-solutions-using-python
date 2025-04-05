class Solution {
    public int subsetXORSum(int[] nums) {
        int res = helper(nums , 0 ,0);
        return res;
    }
  
    int helper(int[] nums , int i , int curr){
        if(i == nums.length){
            return curr;
        }

        int include = helper(nums , i+1 , curr^nums[i]);
        int exclude = helper(nums , i+1 , curr);

        return include + exclude;
    }

}
