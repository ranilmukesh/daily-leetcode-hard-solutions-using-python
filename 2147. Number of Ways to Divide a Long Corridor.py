class Solution:
    def numberOfWays(self, corridor):
        ans = [i for i,c in enumerate(corridor) if c == "S"]

        if len(ans)%2 == 1 or not ans: return 0

        total = 1

        for i in range(1,len(ans)-1,2):
            total *= ans[i+1] - ans[i]

        return total%(10**9+7)
