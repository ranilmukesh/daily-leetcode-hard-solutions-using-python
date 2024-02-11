class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])

        ways = (-1, 0, 1)

        @cache
        def dp(r, c1, c2):
            nonlocal ways, m, n

            if r == m: return 0
            if c1 < 0 or c2 < 0: return 0
            if c1 >= n or c2 >= n: return 0

            curr = grid[r][c1] + grid[r][c2]

            if c1 == c2:
                curr -= grid[r][c1]

            nextVariations = []
            for cc in ways:
                for ccc in ways:
                    nextVariations.append(dp(r+1, c1 + cc, c2 + ccc))

            ans = curr + max(
                nextVariations
            )

            return ans


        return dp(0,0,n-1)
