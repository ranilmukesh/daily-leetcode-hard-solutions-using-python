class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)
        i, j = 0, 1
        for num in nums:
            if num < 0:
                result[j] = num
                j += 2
            else:
                result[i] = num
                i += 2
        
        return result
