class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        return n&(0x55555555) and not n&(n-1)
