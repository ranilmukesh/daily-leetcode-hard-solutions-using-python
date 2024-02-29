
class Solution:
    def isEvenOddTree(self, root: Optional[TreeNode]) -> bool:
        queue = deque([root])
        lvl = 0
        while queue:
            size = len(queue)
            even = (lvl % 2 == 1)
            prev = inf if even else -inf
            for i in range(size):
                node = queue.popleft()
                if even and (node.val % 2 != 0 or node.val >= prev):
                    return False
                if not even and (node.val % 2 == 0 or node.val <= prev):
                    return False
                prev = node.val
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            lvl += 1
        return True

    
