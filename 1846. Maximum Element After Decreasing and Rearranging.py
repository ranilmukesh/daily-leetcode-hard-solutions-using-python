class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        arr.sort()
        maxi=1
        for i in arr[1:]:
            if i>maxi:
                    maxi+=1
        return maxi
