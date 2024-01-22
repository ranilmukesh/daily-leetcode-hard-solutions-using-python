class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        n, memo = len(nums), set()

        for num in nums:
            if num in memo:
                return [num, (n * (n + 1) // 2) - sum(nums) + num]
            memo.add(num)
