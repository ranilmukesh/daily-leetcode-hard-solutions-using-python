class UnionFind:
    def __init__(self, r, c):
        self.ar = [[[-1, -1] for _ in range(c)] for _ in range(r)]
    
    def find(self, i, j, k):
        while self.ar[i][j][k] != -1:
            (i, j, k) = self.ar[i][j][k]
        return (i, j, k)

    def union(self, i, j, k, l, m, n):
        p1, p2 = self.find(i, j, k), self.find(l, m, n)
        if p1 == p2:return
        self.ar[p2[0]][p2[1]][p2[2]] = p1 


class Solution:
    def regionsBySlashes(self, grid: List[str]) -> int:
        r, c = len(grid), len(grid[0])
        uf = UnionFind(r, c)
        for i in range(r):
            for j in range(c):
                if j + 1 < c:
                    uf.union(i, j, 1, i, j + 1, 0)

                if grid[i][j] == ' ':
                    uf.union(i, j, 0, i, j, 1)
                    if i + 1 < r:
                        if grid[i + 1][j] == ' ' or grid[i + 1][j] == '/':
                            uf.union(i, j, 0, i + 1, j, 0)
                        else:
                            uf.union(i, j, 0, i + 1, j, 1)
                elif grid[i][j] == '/':
                    if i + 1 < r:
                        if grid[i + 1][j] == ' ' or grid[i + 1][j] == '/':
                            uf.union(i, j, 1, i + 1, j, 0)
                        else:
                            uf.union(i, j, 1, i + 1, j, 1)
                else:
                    if i + 1 < r:
                        if grid[i + 1][j] == ' ' or grid[i + 1][j] == '/':
                            uf.union(i, j, 0, i + 1, j, 0)
                        else:
                            uf.union(i, j, 0, i + 1, j, 1)
        ans = 0
        for i in range(r):
            for j in range(c):
                if uf.ar[i][j][0] == -1:ans += 1
                if uf.ar[i][j][1] == -1:ans += 1
        return ans

                    















        
