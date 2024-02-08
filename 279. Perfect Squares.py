import math

class Solution:
    def isPerfectSquare(self, x):
        return int(math.sqrt(x)) ** 2 == x
    
    def numSquares(self, n: int) -> int:
        if self.isPerfectSquare(n):
            return 1

        while n % 4 == 0:
            n //= 4
        
        if n % 8 == 7:
            return 4
        
        for i in range(int(math.sqrt(n)) + 1):
            if self.isPerfectSquare(n - i*i):
                return 2
        
        return 3
