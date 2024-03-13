class Solution:
    def pivotInteger(self, n: int) -> int:
        
        s = (n*(n+1)//2)
        k = isqrt(s)
        return k if k**2 == s else -1
