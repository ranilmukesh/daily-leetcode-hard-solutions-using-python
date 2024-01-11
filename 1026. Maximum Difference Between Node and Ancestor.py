class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        q = deque()
        ans = 0
        q.append((root,root.val,root.val))
        while q:
            node,mini,maxi = q.popleft()
            le = node.left
            ri = node.right
            if(le):
                less = min(mini,le.val)
                more = max(maxi,le.val)
                ans = max(ans,more-less)
                q.append((le,less,more))
            if(ri):
                mini = min(mini,ri.val)
                maxi = max(maxi,ri.val)
                ans = max(ans,maxi-mini)
                q.append((ri,mini,maxi))
        return ans
