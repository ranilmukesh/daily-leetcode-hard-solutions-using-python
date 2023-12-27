class Solution:
    def minCost(self, colors: str, neededTime: List[int]) -> int:
        l  = 0
        res = 0
        for r in range(1,len(colors)):
            if colors[l] == colors[r]:
                if neededTime[l] > neededTime[r]:
                    res += neededTime[r]
                else:
                    res += neededTime[l]
                    l = r

            else:
                l = r



        return res
