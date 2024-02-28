class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        q = deque()
        q.append(root)
        res = None
        while q:
            l = []
            for _ in range(len(q)):
                node = q.popleft()
                if node:
                    l.append(node.val)
                    q.append(node.left)
                    q.append(node.right)
                    
            res = l[0] if l else res
            l.clear()
        return res if res!=None else root.val
