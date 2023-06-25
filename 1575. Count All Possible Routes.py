class Solution:
    def countRoutes(self, locations: List[int], start: int, finish: int, fuel: int) -> int:
        mod = 10**9 +7
        dp={}
        def dfs(curr,fuel):
            if (curr,fuel) in dp:
                return dp[(curr,fuel)]
            if fuel<0:
                return 0
            elif fuel>=0:
                ans=0
                if curr==finish:
                    ans=1
                for i in range(len(locations)):
                    if curr!=i:
                        ans+=dfs(i,fuel-abs(locations[i]-locations[curr]))
                dp[(curr,fuel)]=ans
                return dp[(curr,fuel)]%mod

            
        return dfs(start,fuel)
