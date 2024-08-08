class Solution:
    def spiralMatrixIII(self, rows: int, cols: int, rStart: int, cStart: int) -> List[List[int]]:
        ans = [(rStart, cStart)]
        r, c = rStart, cStart
        dr, dc, steps = 0, 1, 1
        while len(ans) < rows * cols:
            if dc and 0 <= r < rows or dr and 0 <= c < cols:
                steps0 = (0 - r) // dr if dr else (0 - c) // dc
                steps1 = (rows - 1 - r) // dr if dr else (cols - 1 - c) // dc
                minSteps = max(min(steps0, steps1), 1)
                maxSteps = min(max(steps0, steps1), steps)
                for s in range(minSteps, maxSteps + 1):
                    ans.append((r + s * dr, c + s * dc))
            r, c = r + steps * dr, c + steps * dc
            dr, dc = dc, -dr
            steps += dr == 0
        return ans
