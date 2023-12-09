class Solution:
    def inorderTraversal(self, r: Optional[TreeNode]) -> List[int]:
        return (self.inorderTraversal(r.left) + [r.val] + self.inorderTraversal(r.right)) if r else []
