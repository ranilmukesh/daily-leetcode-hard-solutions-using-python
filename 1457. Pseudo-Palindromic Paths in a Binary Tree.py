class Solution:
    def pseudoPalindromicPaths (self, root: Optional[TreeNode]) -> int:
        def dfs(node, mask):
            if not node:
                return 0
            new_mask = mask ^ (1 << node.val)
            res = dfs(node.left, new_mask) + dfs(node.right, new_mask)
            if not node.left and not node.right:
                if new_mask.bit_count() in [0, 1]:
                    res += 1 
            return res
        
        return dfs(root, 0)
