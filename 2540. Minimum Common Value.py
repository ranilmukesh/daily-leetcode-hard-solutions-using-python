class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        n = set(nums1).intersection(set(nums2))
        return min(n) if n else -1
