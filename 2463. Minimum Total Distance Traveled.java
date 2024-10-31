class Solution {
    long maxVal=(long)1e12;
    public int absDiff(int x,int y){
        if(x>=y) return x-y;
        return y-x;
    }
    public long minimumTotalDistance(List<Integer> robot, int[][] facts) {
        int n=robot.size(),m=facts.length;
        Collections.sort(robot,(a,b)->a-b);
        Arrays.sort(facts,(a,b)->a[0]-b[0]);
        long[][] dp=new long[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][m]=maxVal;
        for(int i=0;i<=m;i++) dp[n][i]=0;
        
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                long minVal=maxVal;
                long curMov=0;
                int[] fact=facts[j];
                int limit=(i+fact[1]<n)?i+fact[1]:n;
                for(int ind=i;ind<limit;ind++){
                    curMov+=absDiff(fact[0],robot.get(ind));
                    if(minVal>curMov+dp[ind+1][j+1]) minVal=curMov+dp[ind+1][j+1];                 
                }
                if(minVal>dp[i][j+1]) minVal=dp[i][j+1];
                dp[i][j]=minVal;
            }
        }

        return dp[0][0];
    }
}
