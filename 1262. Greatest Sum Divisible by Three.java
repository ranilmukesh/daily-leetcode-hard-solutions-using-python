class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            sum += nums[i];
        }
        if(sum%3 == 0) return sum;
        int count = 0;
        while(sum >= 0){
            sum--;
            count++;
            if(sum%3 == 0){
                if(contains(nums, count)){
                    return sum;
                }
            }
        }
        return 0;
    }

    public boolean contains(int[] nums, int n) {
    if (n < 0) return false;

    boolean[] dp = new boolean[n + 1];
    dp[0] = true;

    int len = nums.length;
    for (int i = 0; i < len; i++) {
        int num = nums[i];
        if (num > n) continue;

        // traverse backwards (0/1 knapsack)
        for (int j = n; j >= num; j--) {
            if (dp[j - num]) dp[j] = true;
        }
    }

    return dp[n];
}

}
