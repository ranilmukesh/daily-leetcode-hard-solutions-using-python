class Solution:
    def putMarbles(self, weights: List[int], k: int) -> int:
        pairCosts = [0] * (len(weights)-1)
        for i in range(len(weights) - 1):
            pairCosts[i] = weights[i] + weights[i + 1]
        pairCosts.sort()
        ans = 0;
        for i in range(k - 1):
            ans += pairCosts[len(pairCosts) - 1 - i] - pairCosts[i]

        return ans
