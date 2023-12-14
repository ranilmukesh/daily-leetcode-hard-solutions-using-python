class Solution:
    def onesMinusZeros(self, grid: List[List[int]]) -> List[List[int]]:
        rows = len(grid)
        cols = len(grid[0])
        rowones = [0] * rows
        colones = [0] * cols
        for ri, row in enumerate(grid):
            for ci, val in enumerate(row):
                if val:
                    rowones[ri] += 2
                    colones[ci] += 2
        bg = -rows -cols
        for ri, rowone in enumerate(rowones):
            row = grid[ri]
            for ci, colone in enumerate(colones):
                row[ci] = bg + rowone + colone
        return grid
