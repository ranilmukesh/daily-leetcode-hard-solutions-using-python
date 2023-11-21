class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        
        return sum(comb(cnt, 2) for cnt in Counter(n-int(str(n)[::-1]) for n in nums).values()) % (10**9+7)       
