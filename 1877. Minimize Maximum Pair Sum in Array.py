class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums.sort()
        pair_sum = 0
        size = len(nums)
        for i in range(size//2):
            if nums[i] + nums[size - (i+1)] > pair_sum:
                pair_sum = nums[i] + nums[size - (i+1)]

        return pair_sum 

        
