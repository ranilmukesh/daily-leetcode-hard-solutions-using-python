class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m,n = len(grid), len(grid[0])
        def floodfill(i,j):
            grid[i][j] = "0"
            if i>0 and grid[i-1][j] == "1":
                floodfill(i-1,j)
            if i+1<m and grid[i+1][j] == "1":
                floodfill(i+1,j)
            if j>0 and grid[i][j-1] == "1":
                floodfill(i,j-1)
            if j+1<n and grid[i][j+1] == "1":
                floodfill(i,j+1)
        islands = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == "1":
                    islands += 1
                    floodfill(i,j)
        return islands
