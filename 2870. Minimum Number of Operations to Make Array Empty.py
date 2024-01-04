class Solution:
    def minOperations(self, A: List[int]) -> int:
        c = Counter(A)
        res = 0
        for key,value in c.items():
            if value == 1: return -1
            m = value % 3 
            res += value // 3
            res += (m // 2) + (m%2)
            
        return res
        
