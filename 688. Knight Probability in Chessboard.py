class Solution:
    def knightProbability(self, n: int, k: int, row: int, column: int) -> float:
        tNodes = 0
        cache = []
        for i in range(k):
            cache.append([[-1] * n for _ in range(n)])
        moves = [(2, 1), (2, -1), (-2, 1), (-2, -1), (1, 2), (1, -2), (-1, 2), (-1, -2)]
        def inRange(t):
            return (t >= 0 and t < n)
        def dfs(curK, r, c):
            if (curK == k):
                return 1
            tmp = 0
            for rMove, cMove in moves:
                rp = r + rMove
                cp = c + cMove
                if (inRange(rp) and inRange(cp)):
                    if (cache[curK][rp][cp] == -1):
                        z = dfs(curK+1, rp, cp)
                        for x, y in [(rp, cp), (cp, rp)]:
                            cache[curK][x][y] = z
                            cache[curK][x][n-1-y] = z
                            cache[curK][n-1-x][y] = z
                            cache[curK][n-1-y][n-1-x] = z
                    else:
                        z = cache[curK][rp][cp]
                    tmp += z
            return tmp
        tNodes = dfs(0, row, column)
        res = tNodes * pow(0.125, k)
        return res
