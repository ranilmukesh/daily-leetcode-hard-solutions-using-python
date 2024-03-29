class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        maxi = max(nums)

        count = i = j = res = 0

        while j < len(nums):
            count = count + 1 if nums[j] == maxi else count

            while count >= k:
                res += len(nums) - j

                count = count - 1 if nums[i] == maxi else count
                i += 1

            j += 1

        return res
