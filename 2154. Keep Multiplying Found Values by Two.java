class Solution {
    public int findFinalValue(int[] nums, int or) {
       for(int i=0;i<nums.length;i++){
            if(nums[i]==or){
                or*=2;
                return findFinalValue(nums, or);
            }
        } 
       return or;
    }
}
