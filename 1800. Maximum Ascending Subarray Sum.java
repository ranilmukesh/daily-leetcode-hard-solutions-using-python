class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        int tempSum = nums[0];
        int arrSize = nums.length;
        for(int index = 1; index < arrSize; index++) {
            if(nums[index] > nums[index - 1]) tempSum += nums[index];
            else if(nums[index] <= nums[index - 1] && tempSum > maxSum) {
                maxSum = tempSum;
                tempSum = nums[index];
            } else {
                tempSum = nums[index];
            }
        }
        return Math.max(tempSum, maxSum);
    }
}
