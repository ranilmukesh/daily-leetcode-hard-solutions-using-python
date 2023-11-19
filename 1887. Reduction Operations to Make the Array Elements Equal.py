class Solution:
    def reductionOperations(self, nums: List[int]) -> int:
        nums.sort()
        curr = nums[0]
        ans = 0
        level = 0
        for n in nums[1:]:
            if n > curr:
                curr = n
                level += 1
            ans += level
        return ans
