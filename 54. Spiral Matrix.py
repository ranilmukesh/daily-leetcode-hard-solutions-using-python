class Solution:
    def spiralOrder(self, x: List[List[int]]) -> List[int]:
        
        return x and [*x.pop(0)] + self.spiralOrder([*zip(*x)][::-1])
