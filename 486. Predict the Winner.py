class Solution:
    def PredictTheWinner(self, nums):
        n = len(nums)

        @lru_cache(None)
        def dfs(i,j):
            if i > j: return 0
            return max(nums[i]-dfs(i+1,j),nums[j]-dfs(i,j-1))

        return dfs(0,n-1) >= 0
