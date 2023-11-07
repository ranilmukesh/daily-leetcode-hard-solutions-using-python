class Solution:
    def eliminateMaximum(self, dist: List[int], speed: List[int]) -> int:
        time = list(map(truediv, dist, speed))
        time.sort()

        for i in range(len(time)):
            if time[i] <= i:
                return i
        return i+1
