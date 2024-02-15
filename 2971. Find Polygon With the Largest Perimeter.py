class Solution:
    def largestPerimeter(self, nums: List[int]) -> int:
        nums.sort(reverse=True)
        n=len(nums)
        for i in range(len(nums) - 2):
            if nums[i] < sum(nums[i+1:n]):
                return sum(nums[i:n])
        return -1
