def dfs(curr_node, adj_list, time, dp, visited):
    visited[curr_node] = True

    for adj in adj_list[curr_node]:
        if not visited[adj]:
            dfs(adj, adj_list, time, dp, visited)

        dp[curr_node] = max(dp[curr_node], time[curr_node] + dp[adj])

class Solution:
    def minimumTime(self, n: int, relations: List[List[int]], time: List[int]) -> int:
        # Turn graph into an adjaceny list
        adj_list = [[] for _ in range(n)]

        for relation in relations:
            adj_list[relation[0] - 1].append(relation[1] - 1)

        # Keep an array of the max path length from each node to the end
        dp = [time[i] for i in range(n)]
        visited = [False for _ in range(n)]

        for i in range(n):
            if not visited[i]:
                dfs(i, adj_list, time, dp, visited)

        return max(dp)







