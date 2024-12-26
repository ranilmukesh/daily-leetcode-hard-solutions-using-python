class Solution {
 
    public int findTargetSumWays(int[] nums, int target) {
    int totalSum = Arrays.stream(nums).sum();
    if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
        return 0;
    }
    int subsetSumTarget = (totalSum + target) / 2; 
    int[] dp = new int[subsetSumTarget + 1];
    dp[0] = 1;

    for (int num : nums) {
        for (int j = subsetSumTarget; j >= num; j--) {
            dp[j] += dp[j - num];
        }
    }

    return dp[subsetSumTarget];
}

}
