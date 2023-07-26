from numpy import array, ceil, sum

class Solution:
    def minSpeedOnTime(self, dist, hour):
        n = len(dist)
        if n == 1:
            return int(ceil(dist[0]/(hour+0.0000000001)))
        distArr = array(dist[0:n-1])
        if hour <= n-1:
            return -1
        def travelTime(speed):
            return sum(ceil(distArr/speed)) + dist[-1]/speed
        l, r = 0, min(10_000_000, int(max(distArr) + ceil(dist[-1]/(hour-n+1))))
        while l+1 < r:
            mid = (l+r) // 2
            if travelTime(mid) <= hour:
                r = mid
            else:
                l = mid
        return r
