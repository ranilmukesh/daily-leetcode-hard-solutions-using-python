class Solution:
    def integerBreak(self, n: int) -> int:
        return n-1 if n<=3 else ((3**(n//3))*2 if n%3==2 else ((3**((n//3)-1))*(n-((n//3-1)*3))))
