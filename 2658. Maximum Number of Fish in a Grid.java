class Solution {

    int n;
    int m;
    public int findMaxFish(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int max = 0;
        for(int i=0;i<n;i++) 
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]!=0)
                {
                    max = Math.max(max, dfs(i, j, grid));
                }
            }
        }
        return max;
    }

    private int dfs(int r, int c, int grid[][])
    {

        if(r<0 || r>=n || c<0 || c>=m || grid[r][c]==0)
        {
            return 0;
        }
        int ans = grid[r][c];
        grid[r][c] = 0;
        ans += dfs(r-1, c, grid) + dfs(r, c+1, grid) + dfs(r+1, c, grid) + dfs(r, c-1, grid);
        return ans;
    } 
}
