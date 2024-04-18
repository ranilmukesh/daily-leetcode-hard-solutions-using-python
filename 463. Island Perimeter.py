class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        
        num_rows = len(grid)
        num_cols = len(grid[0])

        summ = 0
        for i in range(num_rows):
            now = 0                 # now represents water or land
            for j in range(num_cols):
                
                if grid[i][j] != now:
                    summ += 1
                    now = grid[i][j]
            
            if grid[i][-1] == 1:    # When we hit the boundary
                summ += 1
        
        for j in range(num_cols):
            now = 0                 # now represents water or land
            for i in range(num_rows):
                
                if grid[i][j] != now:
                    summ += 1
                    now = grid[i][j]
        
            if grid[-1][j] == 1:   # When we hit the boundary
                summ += 1

        return summ
