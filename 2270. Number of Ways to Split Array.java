class Solution {
    public int waysToSplitArray(int[] nums) {
        int len = nums.length;
        long prefixTotal = 0, prefixL=0;// 
        int count = 0;

        for(int i =0; i<len; i++){
            prefixTotal +=nums[i];//calculating the sum of array daaa
        }

        for(int j=0; j<len-1 ; j++){
            prefixL +=nums[j];
            if(prefixL >= (prefixTotal-prefixL))
            count++;
        }

        return count;
    }
}
