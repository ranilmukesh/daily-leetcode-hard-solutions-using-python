class Solution:
    def isReachableAtTime(self, sx: int, sy: int, fx: int, fy: int, t: int) -> bool:
        if sx == fx and sy == fy:
            return t != 1
        
        a = abs(sx - fx) + 1
        b = abs(sy - fy) + 1

        dis = min(a, b)
        dis += max(a, b) - min(a, b)
        dis -= 1

        return t >= dis
