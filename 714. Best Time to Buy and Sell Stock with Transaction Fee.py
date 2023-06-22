class Solution:
    def maxProfit(self, prices: list[int], fee: int) -> int:

        ownShare, noShare = -prices[0], 0

        for price in prices:
            ownShare, noShare = (max(ownShare, noShare-price),
            max( noShare, ownShare + price-fee))

        return noShare
