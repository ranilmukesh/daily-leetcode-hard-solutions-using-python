class Solution:
    def minimizeMax(self, nums: list[int], p: int) -> int:
        if p == 0: return 0

        nums.sort()
        pairs = [(nums[i+1] - nums[i],i) for i in range(len(nums)-1)]
        pairs.sort()

        m = [0]*len(nums)
        for i, (d,loc) in enumerate(pairs):
            l, r = m[loc-1], m[loc+1]
            m[loc] = m[loc-l] = m[loc+r] = l+r+1
            p -= 1&~(l|r)
            if p == 0: return d
