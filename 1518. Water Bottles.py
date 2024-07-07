class Solution:
    def numWaterBottles(self, numBottles: int, numExchange: int):
        final_ans = numBottles

        while(numBottles>=numExchange):
            q=numBottles//numExchange
            r=numBottles%numExchange
            final_ans+=q
            numBottles=q+r
        return(final_ans)
