class Solution:
    def largestLocal(self, grid: List[List[int]]) -> List[List[int]]:
        new_grid=[]
        for i in range(len(grid[0])-2):
            new_grid.append([])
            for j in range(len(grid[0])-2):
                new_grid[i].append(
                    max(
                        max(grid[i][j:j+3]),
                        max(grid[i+1][j:j+3]),
                        max(grid[i+2][j:j+3])
                    )
                )
        return new_grid

        
