class Solution:
    def checkArithmeticSubarrays(self, nums: List[int], l: List[int], r: List[int]) -> List[bool]:
        
        def checkAP(arr):
            start, end, n = min(arr), max(arr), len(arr)
            step, tail = divmod(end - start, n - 1)
            
            if tail != 0: return False
            if end - start == 0: return True
            
            numbers = set(arr)
            for num in range(start, end, step):
                if num not in numbers: return False

            return True
        
        ans = []
        for i, j in zip(l, r):
            ans.append(checkAP(nums[i:j + 1]))
        
        return ans
