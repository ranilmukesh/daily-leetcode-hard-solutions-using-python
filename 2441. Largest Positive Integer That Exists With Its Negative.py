class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        negative: set[int] = {num for num in nums if num < 0}
        answer: int = -1
        for num in nums:
            if num > answer and -num in negative:
                answer = num
        return answer
