class Solution:
    def minimumFinishTime(self, tires, changeTime, numLaps):
        ans = [float("inf")]*20

        for f,r in tires:
            prefix = val = f
            for i in range(20):
                ans[i] = min(ans[i],prefix)
                val = val*r
                if val >= f + changeTime: break
                prefix += val

        @lru_cache(None)
        def dfs(n):
            min_val = ans[n-1] if n <= 20 else float("inf")

            for j in range(1,min(20,n//2)+1):
                min_val = min(min_val,dfs(j) + dfs(n-j) + changeTime)

            return min_val 

        return dfs(numLaps)
