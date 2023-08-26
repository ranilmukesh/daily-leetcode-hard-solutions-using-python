class Solution:
    def findLongestChain(self, pairs: List[List[int]]) -> int:

        pairs = sorted(pairs, key=lambda x: x[1])
        count = 0
        min_last = -math.inf

        for pair in pairs:
            x, y = pair
            if min_last < x: 
                min_last = y
                count += 1

        return count
