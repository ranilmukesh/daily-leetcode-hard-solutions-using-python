# Input: nums1 = [1,4,2], nums2 = [1,2,4]
# Output: 2
# Explanation: We can draw 2 uncrossed lines as in the diagram.
# We cannot draw 3 uncrossed lines, because the line from nums1[1] = 4 to nums2[2] = 4 will intersect the line from nums1[2]=2 to nums2[1]=2.
# Example 2:

# Input: nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
# Output: 3
# Example 3:

# Input: nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
# Output: 2
  
  
# THE CODE IS :::::-
          
class Solution:
    def maxUncrossedLines(self, nums1: List[int], nums2: List[int]) -> int:
        n, m = len(nums1), len(nums2)
        if n < m:
            return self.maxUncrossedLines(nums2, nums1)
        
        dp = [0] * (m + 1)
        for i in range(1, n + 1):
            prev = 0
            for j in range(1, m + 1):
                curr = dp[j]
                if nums1[i-1] == nums2[j-1]:
                    dp[j] = prev + 1
                else:
                    dp[j] = max(dp[j-1], curr)
                prev = curr
        
        return dp[m]
