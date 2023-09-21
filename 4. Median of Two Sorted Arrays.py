class Solution:
    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        for i in nums2:
            nums1.append(i)  
        a=sorted(nums1)
        if len(a)%2==1:
            return a[len(a)//2]
        else:
            return (a[len(a)//2]+a[len(a)//2 - 1])/2
