import bisect
class Solution:
    def minOperations(self, nums: List[int]) -> int:
        n = len(nums)
        nums = sorted(set(nums))
        offset = 1
        for i, num in enumerate(nums):
            expected_end = num + n
            while i + offset < len(nums):
                if nums[i + offset] < expected_end:
                    offset += 1
                else:
                    break     
            else:
                break     
        return n - offset
