class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        
        int minElement = numsCopy[numsCopy.length - k], minElementCounter = 0;
        for (int i = numsCopy.length - k; i < numsCopy.length; i++) {
            if (numsCopy[i] != minElement) {
                break;
            }
            minElementCounter++;
        }

        int[] subsequence = new int[k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
        if (nums[i] > minElement || (nums[i] == minElement && minElementCounter-- > 0)) {
                subsequence[index++] = nums[i];
                if (index == k) {
                    break;
                }
            }
        }
        return subsequence;
    }
}
