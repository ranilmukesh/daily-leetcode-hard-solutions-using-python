class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int) -> int:
        drinked = 0

        empty = 0
        full = numBottles 

        while full > 0:
            drinked += full
            empty += full

            N = empty // numExchange
            full = N
            empty -= N * numExchange
        
        return drinked
