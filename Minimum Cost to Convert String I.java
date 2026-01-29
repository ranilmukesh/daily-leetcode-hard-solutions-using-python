class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n=26;
        int dist[][] = new int[n][n];
        int inf=Integer.MAX_VALUE;
        for (int i=0; i<n; i++){
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }
        for (int i=0; i<cost.length; i++)
                dist[original[i]-'a'][changed[i]-'a'] = Math.min(dist[original[i]-'a'][changed[i]-'a'],cost[i]);
        //floyd algo
        for (int k=0; k<n; k++){
            for (int i=0; i<n; i++){
                if (dist[i][k]<inf){
                    for (int j=0; j<n; j++){
                        if (dist[k][j]<inf)
                            dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                    }
                }
            }
        }
        long minCost=0;
        for (int i=0; i<source.length(); i++){
            int s=source.charAt(i)-'a';
            int t=target.charAt(i)-'a';
            if (dist[s][t]==inf)
                return -1;
            minCost+=(long)dist[s][t];
        }
        return minCost;
    }
}
