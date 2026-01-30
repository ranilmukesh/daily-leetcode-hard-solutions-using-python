from collections import defaultdict
import heapq
class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        # build adjacency list
        adj_list = defaultdict(list)
        for idx in range(len(original)):
            adj_list[original[idx]].append((cost[idx], changed[idx]))
        
        # do n^2 dfs to find shortest path length
        dfs = defaultdict(lambda: defaultdict(lambda: float('inf')))
        for start in original:
            # disjktra with this start node
            dfs[start][start] = 0
            pq = [(0, start)]
            visited = set()
            while pq:
                dist, vtx = heapq.heappop(pq)
                if vtx in visited:
                    continue
                visited.add(vtx)
                dfs[start][vtx] = dist
                # then add to queue
                for cost, child in adj_list[vtx]:
                    new_dist = dist + cost
                    if child not in visited:
                        heapq.heappush(pq, (new_dist, child))
        
        ## this below part is what takes too long ##
        n = len(source)
        INF = float('inf')
        dp = [INF] * (n + 1)
        dp[0] = 0

        original_set = set(original)
        changed_set = set(changed)
        valid_lengths = set(len(s) for s in original_set)

        for i in range(n):
            if dp[i] == INF:
                continue

            # Case 1: no-op if characters match
            if source[i] == target[i]:
                dp[i + 1] = min(dp[i + 1], dp[i])

            # Case 2: try transformations
            for L in valid_lengths:
                if i + L > n:
                    continue

                s_sub = source[i:i + L]
                if s_sub not in original_set:
                    continue

                t_sub = target[i:i + L]
                cost_val = dfs[s_sub][t_sub]
                if cost_val < INF:
                    dp[i + L] = min(dp[i + L], dp[i] + cost_val)
        return -1 if dp[n] == INF else dp[n]
