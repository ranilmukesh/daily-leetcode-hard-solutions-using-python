# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:

        def getLeafNodes(node, ans=[]):
            if not node:
                return
            if not node.left and not node.right:
                ans.append(node.val)
            else:
                getLeafNodes(node.left, ans)
                getLeafNodes(node.right, ans)
            return ans
        
        leaf1 = getLeafNodes(root1, [])
        leaf2 = getLeafNodes(root2, [])
        return leaf1 == leaf2
