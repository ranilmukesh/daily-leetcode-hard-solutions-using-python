class Solution:
    def generateTrees(self, n):
        @lru_cache(None)
        def dfs(start,end):
            if start > end:
                return [None]

            res = []

            for i in range(start,end+1):
                for left in dfs(start,i-1):
                    for right in dfs(i+1,end):
                        root = TreeNode(i)
                        root.left = left
                        root.right = right
                        res.append(root)

            return res

        return dfs(1,n)
