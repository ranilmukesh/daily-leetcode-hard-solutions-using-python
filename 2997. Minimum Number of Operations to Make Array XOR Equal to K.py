class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        x = 0
        for num in nums:
            x ^= num
        cnt = 0
        for i in range(32):
            if (x & (1<<i)) != (k & (1<<i)):
                cnt += 1
        return cnt
