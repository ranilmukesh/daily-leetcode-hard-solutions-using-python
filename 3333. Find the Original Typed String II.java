class Solution {
    public int possibleStringCount(String word, int k) {
        if(word.length()==k) return 1;
        List<Integer> list = new ArrayList<>();
        int n = word.length();
        int i = 0;
        while (i < n) {
            int j = i+1;
            while (j < n && word.charAt(j) == word.charAt(j-1)) j++;
            list.add(j - i);
            i = j;
        }
        int m = list.size();
        long[] power = new long[m];
        power[m-1] = list.get(m-1);
        for (i = m-2; i >= 0; i--) {
            power[i] = (power[i+1] * list.get(i)) % MOD;
        }
        if (m >= k) return (int)power[0];
        long[][] dp = new long[m][k-m+1];
        for (i = 0; i < k-m+1; i++) {
            if (list.get(m-1) + i + m > k) dp[m-1][i] = list.get(m-1) - (k-m-i);
        }
        for (i = m-2; i >= 0; i--) {
            long sum = (dp[i+1][k-m] * list.get(i)) % MOD;
            for (int j = k-m; j >= 0; j--) {
                sum += dp[i+1][j];
                if (j + list.get(i) > k-m) sum = (sum - dp[i+1][k-m] + MOD) % MOD;
                else sum = (sum - dp[i+1][j+list.get(i)] + MOD) % MOD;
                dp[i][j] = sum;
            }
        }
        return (int)dp[0][0];
    }
    private static final long MOD = (long)1e9 + 7;
}
