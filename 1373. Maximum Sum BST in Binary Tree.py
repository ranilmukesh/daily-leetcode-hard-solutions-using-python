class Solution:
    def maxSumBST(self, root: Optional[TreeNode]) -> int:
        self.ans = 0
        def postOrder(node):
            if not node:
                return [0,-1e9,1e9]
            [l_sum,l_max,l_min]  = postOrder(node.left)
            [r_sum,r_max,r_min]  = postOrder(node.right)
            if l_max < node.val < r_min:
                self.ans = max(self.ans,l_sum + r_sum + node.val)
                return [l_sum + r_sum + node.val,max(node.val,r_max),min(node.val,l_min)]
            return [max(l_sum,r_sum) , 1e9 , -1e9]
        postOrder(root)
        return self.ans
