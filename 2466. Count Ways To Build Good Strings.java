class Solution {

    public int countGoodStrings(int low, int high, int zero, int one) {
        System.gc();

        int MOD = 1_000_000_007;
        int[] dp = new int[high + 1];
        dp[0] = 1;

        for(int i = 1; i<=low; ++i) dp[i] = ((i >= zero ? dp[i - zero] : 0) + (i >= one ? dp[i - one] : 0)) % MOD;

        int sum = 0;

        do sum = (sum + (dp[low] = ((low >= zero ? dp[low - zero] : 0) + (low >= one ? dp[low - one] : 0)) % MOD)) % MOD;
        while(++low<=high);
        
        return sum;
    }
}
