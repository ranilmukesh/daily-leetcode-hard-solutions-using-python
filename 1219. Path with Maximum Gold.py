class Solution:
    def getMaximumGold(self, grid: List[List[int]]) -> int:
        def ncount(i, j):
            return (
                (i > 0 and grid[i-1][j] and 1)
                + (j > 0 and grid[i][j-1] and 1)
                + (i < len(grid)-1 and grid[i+1][j] and 1)
                + (j < len(grid[0])-1 and grid[i][j+1] and 1)
            )
        def step(i, j):
            nexts = []
            curgold = grid[i][j]
            grid[i][j] = 0
            nexts.append(i > 0 and grid[i-1][j] and step(i-1, j))
            nexts.append(j > 0 and grid[i][j-1] and step(i, j-1))
            nexts.append(i < len(grid)-1 and grid[i+1][j] and step(i+1, j))
            nexts.append(j < len(grid[0])-1 and grid[i][j+1] and step(i, j+1))
            grid[i][j] = curgold
            return curgold + max(nexts)

        ans = 0
        total = sum(sum(line) for line in grid)
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] and ncount(i, j) < 3:
                    if (a := step(i, j)) > ans:
                        ans = a
                        if ans == total:
                            return total
        return ans
