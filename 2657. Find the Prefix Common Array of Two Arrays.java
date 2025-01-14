class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] res = new int[n];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 0;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = A[i] - 1;
            int b = B[i] - 1;
            dp[a] += 1;
            count += (dp[a] == 2) ? 1 : 0;
            dp[b] += 1;
            count += (dp[b] == 2) ? 1 : 0;
            res[i] = count;
        }
        return res;
    }
}
