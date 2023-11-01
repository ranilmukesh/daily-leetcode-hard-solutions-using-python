class Solution:
    def inorder(self, node):
        if not node:
            return

        self.inorder(node.left)
        if self.prev and self.prev.val == node.val:
            self.curCount += 1
        else: self.curCount = 1

        if self.curCount > self.count:
            self.modes = [node.val]
            self.count = self.curCount
        elif self.curCount == self.count:
            self.modes.append(node.val)

        self.prev = node
        self.inorder(node.right)

    def findMode(self, root: Optional[TreeNode]) -> List[int]:
        self.prev = None
        self.curCount = 0
        self.count = 0
        self.modes = []

        self.inorder(root)

        return self.modes
