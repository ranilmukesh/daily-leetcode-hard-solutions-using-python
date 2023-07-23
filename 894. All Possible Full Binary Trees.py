class Solution:
    def allPossibleFBT(self, n):
        if n%2==0: return []

        dp = [[TreeNode()]]+[[] for i in range(n//2)]

        for i in range(1, n//2+1):
            for j in range(i):
                for left in dp[j]:
                    for right in dp[i-j-1]:
                        dp[i].append(TreeNode(0, left, right))

        return dp[-1]
