class Solution:
    def maxIncreasingGroups(self, usageLimits: List[int]) -> int:
        cur = 0
        ans = 0
        s = usageLimits
        s.sort()
        for i in range(len(s)):
            cur += s[i]
            if cur >= ((ans+1)*(ans+2))//2:
                ans += 1
            
        return ans
