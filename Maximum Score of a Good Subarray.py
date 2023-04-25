# You are given an array of integers nums (0-indexed) and an integer k.

# The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.

# Return the maximum possible score of a good subarray.

#leetcode hard - 1793

# You are given an array of integers nums (0-indexed) and an integer k.

# The score of a subarray (i, j) is defined as min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1). A good subarray is a subarray where i <= k <= j.

# Return the maximum possible score of a good subarray.

print("code by ranil")
  
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
      
      #99.58 in runtime
