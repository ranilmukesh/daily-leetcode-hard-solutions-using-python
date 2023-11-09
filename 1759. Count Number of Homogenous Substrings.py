class Solution:
    def countHomogenous(self, s: str) -> int:
        mod=10**9+7
        ans=0
        for x,y in groupby(s):
            n=len(list(y))
            ans+=n*(n+1)//2
        return ans%mod    
