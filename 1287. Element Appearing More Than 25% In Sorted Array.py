from statistics import mode

class Solution:
    def findSpecialInteger(self, A: List[int]) -> int:
        return mode(A)
