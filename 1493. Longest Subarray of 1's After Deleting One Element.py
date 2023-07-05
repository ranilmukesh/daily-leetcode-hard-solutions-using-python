class Solution:
    def longestSubarray(self, nums: List[int]) -> int:
        zeros = [i for i in range(len(nums)) if not nums[i]]
        if not zeros or len(nums) == 1: 
            return len(nums) - (not zeros)
        zeros = [-1] + zeros + [len(nums)]
        return max(z3 - z1 - 2 for z1, _, z3 in zip(zeros, zeros[1:], zeros[2:]))
