# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:

        if depth == 1:
            return TreeNode(val, root)

        # rootCopy = root
        q = deque([root])
        depth -= 1

        while q and depth > 0:
            depth -= 1
            for _ in range(len(q)):
                node = q.popleft()
                if not node:
                    continue

                if depth == 0:
                    node.left = TreeNode(val, left=node.left)
                    node.right = TreeNode(val, right=node.right)

                else:
                    q.append(node.left)
                    q.append(node.right)

        return root
