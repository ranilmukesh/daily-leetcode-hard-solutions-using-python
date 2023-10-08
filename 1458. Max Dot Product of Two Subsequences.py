class Solution:
    def maxDotProduct(self, nums1: list[int], nums2: list[int]) -> int:
        dp = [[0]*(len(nums2)) for _ in range(len(nums1))]

        a_, *nums1 = nums1
        b_, *nums2 = nums2

        dp[0][0] = a_ * b_
        
        for i, a in enumerate(nums1, 1):
            dp[i][0] = max(dp[i-1][0], a * b_)
        
        for j, b in enumerate(nums2, 1):
            dp[0][j] = max(dp[0][j-1], b * a_)

        for i, a in enumerate(nums1, 1):
            for j, b in enumerate(nums2, 1):
                prod = a * b
                dp[i][j] = max(prod, 
                               prod + dp[i-1][j-1],
                               dp[i-1][j], 
                               dp[i][j-1], 
                               )
        return dp[-1][-1]
