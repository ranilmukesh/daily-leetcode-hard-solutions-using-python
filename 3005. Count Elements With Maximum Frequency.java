

class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        frequencies = {}
        max_ = 0
        for n in nums:
            frequencies[n] = frequencies.get(n, 0) + 1
            max_ = max(max_, frequencies[n])
        
        ans = 0
        for v in frequencies.values():
            if v == max_:
                ans += v
        
        return ans
