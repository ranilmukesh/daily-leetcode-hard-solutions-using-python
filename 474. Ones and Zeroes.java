class Solution {

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (String str : strs) {
            int zeroCnt = 0;
            int oneCnt = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroCnt++;
                } else {
                    oneCnt++;
                }
            }

            for (int i = m; i >= zeroCnt; i--) {
                for (int j = n; j>= oneCnt; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-zeroCnt][j-oneCnt] + 1);
                }
            }
        }

        return dp[m][n];
    }
}
