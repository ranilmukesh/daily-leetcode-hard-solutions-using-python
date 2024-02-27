class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def dd(n, cd):
            if not n: return (cd - 1, 0)
            depthl, diameterl = dd(n.left, cd + 1)
            depthr, diameterr = dd(n.right, cd + 1)
            return (max(depthl, depthr), max(diameterl, diameterr, depthl + depthr - 2 * cd))
        return dd(root, 0)[1]
