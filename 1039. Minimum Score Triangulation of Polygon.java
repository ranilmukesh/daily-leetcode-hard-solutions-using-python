class Solution {
    public static int mcmMem(int arr[], int i, int j, int dp[][]){
        if(i==j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i; k<j; k++){
            int cost1 = mcmMem(arr, i, k, dp);
            int cost2 = mcmMem(arr, k+1, j, dp);
            int cost3 = arr[i-1]*arr[k]*arr[j];
            ans = Math.min(ans, cost1+cost2+cost3);
        }

        return dp[i][j]=ans;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(dp[i], -1);
        }
        
        return mcmMem(values, 1, n-1, dp);
    }
}
