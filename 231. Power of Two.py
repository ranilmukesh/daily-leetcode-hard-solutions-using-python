class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        su = 1

        while su <= n:
            if su == n:
                return True
            su*=2
            
        
        return False
                
