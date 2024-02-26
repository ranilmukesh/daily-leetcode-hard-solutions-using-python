class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        return True if (p==q==None) or (p and q and p.val==q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)) else False
        
