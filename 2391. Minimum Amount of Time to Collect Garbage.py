class Solution:
    def garbageCollection(self, garbage: List[str], travel: List[int]) -> int:
        ans, m, p, g = 0, 0, 0, 0
        for i, stop in enumerate(garbage):
            if 'M' in stop: m = i
            if 'P' in stop: p = i
            if 'G' in stop: g = i
            ans += len(stop)
        ans += sum(travel[:m]) + sum(travel[:p]) + sum(travel[:g])
        return ans
