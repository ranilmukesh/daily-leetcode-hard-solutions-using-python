class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        l1, l2 = len(nums1), len(nums2)
        res = set()

        if l1 <= l2:
            nums1 = set(nums1)
            for num in nums2:
                if num in nums1:
                    res.add(num)
        else:
            nums2 = set(nums2)
            for num in nums1:
                if num in nums2:
                    res.add(num)
        
        return res
