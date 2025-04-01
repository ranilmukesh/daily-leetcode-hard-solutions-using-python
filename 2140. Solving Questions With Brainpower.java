class Solution {
    private long recur(int i,int[][] questions,long[] dp,int n){
        if(i>=n) return 0l;
        if(dp[i]!=0) return dp[i];
        long take=questions[i][0]+recur(i+questions[i][1]+1,questions,dp,n);
        long notTake=recur(i+1,questions,dp,n);
        return dp[i]=Math.max(take,notTake);
    }
    public long mostPoints(int[][] questions) {
        int n=questions.length;
        long[] dp=new long[n];
        // return recur(0,questions,dp,n);
        dp[n-1]=questions[n-1][0];
        for(int i=n-2;i>=0;i--){
            long take=questions[i][0];
            int newIndex=i+questions[i][1]+1;
            take+=(newIndex<n)?dp[newIndex]:0;
            long notTake=dp[i+1];
            dp[i]=Math.max(take,notTake);
        }
        return dp[0];
    }
}
