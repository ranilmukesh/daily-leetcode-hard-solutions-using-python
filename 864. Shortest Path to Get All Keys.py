class Solution:
    def shortestPathAllKeys(self, grid: List[str]) -> int:
        n, m = len(grid), len(grid[0])
        graph = {}
        crit_points = []
        dirs = [[-1, 0], [1, 0], [0, 1], [0, -1]]
        ids = {'@':6, 'a':0, 'b':1, 'c':2, 'd':3, 'e':4, 'f':5, 'A':7, 'B':8, 'C':9, 'D':10, 'E':11, 'F':12}
        for i, row in enumerate(grid):
            for j, val in enumerate(row):
                if val!='.' and val!='#':
                    crit_points.append((i, j))
        for i, j in crit_points:
            key = grid[i][j]
            graph[key] = []
            q = deque()
            explored = set()
            q.append((i, j, 0))
            while len(q)>0:
                x, y, dist = q[0]
                q.popleft()

                if x*m+y in explored:
                    continue

                explored.add(x*m+y)

                if grid[x][y]=='.' or grid[x][y]==key:
                    for d in dirs:
                        xP, yP = x+d[0], y+d[1]
                        if 0<=xP<n and 0<=yP<m and xP*m+yP not in explored:
                            q.append((xP, yP, dist+1))
                elif grid[x][y]!='#':
                    graph[key].append((grid[x][y], dist))
        numKeys = (len(crit_points)-1)//2
        memo = [[False for x in range(64)] for y in range(len(ids))]
        @lru_cache(None)
        def dfs(start, keys):
            if keys==(1<<numKeys)-1:
                return 0
            if memo[ids[start]][keys]:
                return -1

            memo[ids[start]][keys] = True
            res = 2**63
            for edge in graph[start]:
                if edge[0].isupper() and keys&(1<<ids[edge[0].lower()])>0:
                    temp = dfs(edge[0], keys)
                    if temp!=-1:
                        res = min(res, edge[1]+temp)
                    continue
                if edge[0].islower():
                    temp = dfs(edge[0], keys|(1<<ids[edge[0]]))
                    if temp!=-1:
                        res = min(res, edge[1]+temp)
                    continue
                if not edge[0].isupper():
                    temp =  dfs(edge[0], keys)
                    if temp!=-1:
                        res = min(res, edge[1]+temp)
            if res>=2**63:
                return -1
            return res
        return dfs('@', 0)                
