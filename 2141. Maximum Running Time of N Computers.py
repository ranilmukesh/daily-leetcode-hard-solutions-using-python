class Solution(object):
    def maxRunTime(self, n, batteries):
        m = len(batteries)
        if n==m:
            return min(batteries)
        if m < n:
            return 0
        batteries.sort()
        S = sum(batteries)
        T = S//n
        for i in range(1,n):
            S -= batteries[-i]
            T = min(T, S//(n-i))
        return T
