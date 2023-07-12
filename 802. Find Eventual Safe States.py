class Solution:
    def eventualSafeNodes(self, graph: List[List[int]]) -> List[int]:
        dp = [None] * len(graph)
        def dfs(i):
            if dp[i] is not None:
                return dp[i]
            dp[i] = False
            dp[i] = all(dfs(j) for j in graph[i])
            return dp[i]
        return [i for i in range(len(graph)) if dfs(i)]
