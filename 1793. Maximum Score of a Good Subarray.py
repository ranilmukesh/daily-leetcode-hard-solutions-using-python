class Solution:
    def maximumScore(self, nums: List[int], k: int) -> int:

        left = right = k  ;  ans = mn = nums[k]
        n = len(nums)

        while left > 0 or right < n - 1:
            while left  >     0 and nums[left  - 1] >= mn: left  -= 1
            while right < n - 1 and nums[right + 1] >= mn: right += 1

            ans = max(ans, (right - left + 1) * mn)

            beg = nums[left  - 1] if left  >     0 else -1
            end = nums[right + 1] if right < n - 1 else -1

            mn = max(beg, end)

        return ans
