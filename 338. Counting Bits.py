class Solution:
    def countBits(self, n: int) -> List[int]:
        return [_.bit_count() for _ in range(n+1)]
        
