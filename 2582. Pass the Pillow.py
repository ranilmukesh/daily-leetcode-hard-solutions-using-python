class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        return abs(time//(n:=n-1)%2*n-time%n)+1
