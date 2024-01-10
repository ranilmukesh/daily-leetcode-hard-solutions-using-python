class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:
        s = [[root, 0]]
        while s[-1][0].val != start:
            if s[-1][1] == 0:
                s[-1][1] = 1
                if s[-1][0].left:
                    s.append([s[-1][0].left, 0])
            elif s[-1][1] == 1:
                s[-1][1] = 2
                if s[-1][0].right:
                    s.append([s[-1][0].right, 0])
            else:
                s.pop()
        def depth(vertex):
            if not vertex: return -1
            return 1 + max(depth(vertex.left), depth(vertex.right))
        ans = 0
        n = len(s)-1
        for i in range(n, -1, -1):
            if i < n:
                # disconnect s[i][0] and s[i+1][0]
                if s[i][0].left == s[i+1][0]:
                    s[i][0].left = None
                else:
                    s[i][0].right = None
            ans = max(ans, n-i+depth(s[i][0]))
        return ans
