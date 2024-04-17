# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        
        val_a = 97
        def dfs(node, current_str='', small_str=None):
            if not node:
                return small_str
            
            if not node.left and not node.right:
                current_str += chr(node.val + val_a)
                
                if not small_str : 
                    small_str = current_str[::-1]
                else:
                    if small_str > current_str[::-1]:
                        small_str = current_str[::-1]

                return small_str
            else:
                current_str += chr(node.val + val_a)
            
            small_str = dfs(node.left, current_str, small_str)
            small_str = dfs(node.right, current_str, small_str)
            return small_str

        small_str = dfs(root)
        #print(small_str)
        return small_str
