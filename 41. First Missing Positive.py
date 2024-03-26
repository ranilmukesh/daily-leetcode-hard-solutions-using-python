class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        s = set(nums)
        max_num = abs(max(s))
        for i in range(1, max_num + 1):
            if i not in s:
                return i
        return max_num + 1
