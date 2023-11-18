from typing import List

class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort()  # Step 1
        n = len(nums)
        max_freq = 0
        i = 0
        total_operations = 0

        for j in range(n):
            total_operations += nums[j]

            while (j - i + 1) * nums[j] > total_operations + k:
                total_operations -= nums[i]
                i += 1

            max_freq = max(max_freq, j - i + 1)

        return max_freq
