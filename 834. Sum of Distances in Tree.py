class Solution:
  def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
    child = [1 for _ in range(n)] 
    dist = [0 for _ in range(n)]
    mark = [False for _ in range(n)] 
    g = [[] for _ in range(n)] 
    for i in edges:
      g[i[0]].append(i[1])
      g[i[1]].append(i[0])

    def dfs(x:int):
      mark[x] = True 
      for i in g[x]:
        if not mark[i]:
          dfs(i)
          dist[x] += dist[i]
          child[x] += child[i]
      if x!= 0 : dist[x] += child[x]

    def calc(x:int):
      mark[x] = True 
      for i in g[x]:
        if not mark[i]:
          dist[i] = dist[x] + child[0] - 2 * child[i] 
          calc(i)
      return 

    dfs(0) 
    mark = [False for _ in range(n)]
    calc(0) 

    return dist
