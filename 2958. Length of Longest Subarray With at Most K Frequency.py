class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        hashMap = {}
        l, res = 0,0

        for r in range(len(nums)):
            hashMap[nums[r]] = 1 + hashMap.get(nums[r], 0)
            while hashMap[nums[r]] > k:
                hashMap[nums[l]] = hashMap.get(nums[l]) - 1
                l += 1
            res = max(res, r - l + 1)
        
        return res
