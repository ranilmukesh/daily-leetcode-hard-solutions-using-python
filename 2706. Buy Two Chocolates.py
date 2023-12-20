class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        prices.sort()
        if prices[0]>=money:
            return money
        else:
            k=(money-prices[0]-prices[1])
            if k<0:
                return money
            else:
                return k
