class Solution {
    public int maxMoves(int[][] grid) {
        int maxMoves = 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] dp = new boolean[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = true;
        }
        for (int level = 1; level < n; level++) {
            boolean movePossible = false;

            for(int i = 0; i < m; i++){
                if(i == 0){
                    dp[0][level] = (grid[0][level] > grid[0][level-1] && dp[0][level-1]) ||
                                    (grid[0][level] > grid[1][level-1] && dp[1][level-1]);
                }
                else if(i == m-1){
                    dp[m-1][level] = (grid[m-1][level] > grid[m-1][level-1] && dp[m-1][level-1]) || 
                                    (grid[m-1][level] > grid[m-2][level-1] && dp[m-2][level-1]);
                }
                else{
                    dp[i][level] = (grid[i][level] > grid[i][level-1] && dp[i][level-1]) ||
                                   (grid[i][level] > grid[i-1][level-1] && dp[i-1][level-1]) || 
                                   (grid[i][level] > grid[i+1][level-1] && dp[i+1][level-1]);
                }
                if(dp[i][level]) movePossible = true;
            }
            if (movePossible) maxMoves++;
            else break; 
        }
        return maxMoves;  
    }
}
