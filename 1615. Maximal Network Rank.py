class Solution:
    def maximalNetworkRank(self, n: int, roads: List[List[int]]) -> int:
        dp = [0] * n
        maxdp = 0
        r = set()
        res = 0        

        for i, j in roads:
            dp[i] += 1
            dp[j] += 1
            r.add((i, j) if i < j else (j, i))

        for i in range(n - 1):
            if dp[i] < maxdp:
                continue
            maxdp = dp[i]
            for j in range(i + 1, n):
                s = dp[i] + dp[j] 
                if s > res:
                    res = s - ((i, j) in r)

        return res
