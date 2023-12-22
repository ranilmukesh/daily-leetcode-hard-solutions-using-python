class Solution:
    def maxScore(self, s: str) -> int:
        ans=0
        for i in range(1,len(s)):
            left=s[:i]
            right=s[i:]
            maxs=left.count("0")+right.count("1")
            ans=max(ans,maxs)
        return ans
