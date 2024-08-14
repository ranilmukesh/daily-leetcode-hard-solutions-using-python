class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
 
        def check(dist: int)-> bool:

            i = j = cnt = 0

            for i in range(n):                             
                while j < n and nums[j] - nums[i] <= dist:  
                    cnt += j - i
                    j += 1

            return cnt >= k                                 
        nums.sort()
        n, left, right = len(nums), 0, nums[-1] - nums[0]

        while left < right:                                

            mid = (left + right) // 2
            if check(mid): right = mid
            else: left = mid + 1

        return left
