class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        j=sum(nums)
        a=0
        for i in range(len(nums)+1):
           a+=i
        return a-j
