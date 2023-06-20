class Solution:
    def getAverages(self, nums: List[int], k: int) -> List[int]:
        res = len(nums) * [-1]
        d, s = k * 2 + 1, 0
        for i in range(k, len(nums)-k):
            if s: s = s - nums[i-k-1] + nums[i+k]
            else: s = sum(nums[i-k:i+k+1])
            res[i] = s // d
        return res
