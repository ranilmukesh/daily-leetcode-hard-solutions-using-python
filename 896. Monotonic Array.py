class Solution:
    def isMonotonic(self, nums: List[int]) -> bool:
        increasing_res = all(i <= j for i, j in zip(nums, nums[1:]))
        decreasing_res = all(i >= j for i, j in zip(nums, nums[1:]))

        if increasing_res or decreasing_res:
            return True
        else:
            return False
