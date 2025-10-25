class Solution:
    def totalMoney(self, n: int) -> int:
        if n <= 7:
            return (n * (n + 1)) // 2
        
        qty = res = 28
        fullWeeks = n // 7
        for wk in range(1, fullWeeks):
            qty += 7
            res += qty
        
        remainder_Week_Start = fullWeeks + 1
        remainderDays = n - (7 * fullWeeks)
        for qty in range(remainder_Week_Start, remainder_Week_Start + remainderDays):
            res += qty
        
        return res
