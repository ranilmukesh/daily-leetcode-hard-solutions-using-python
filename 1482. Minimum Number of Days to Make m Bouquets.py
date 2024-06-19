import math

class Solution:
    def minDays(self, bloomDay: List[int], m: int, k: int) -> int:
        n = len(bloomDay)
        flowers = m * k
        ans = math.inf
        low, high = min(bloomDay), max(bloomDay)
        
        if flowers > n:
            return -1
        else:
            while low <= high:
                mid = (low + high) // 2
                count = self.findFlowers(bloomDay, mid, k, m)
                
                if count >= m:
                    ans = min(ans, mid)
                    high = mid - 1
                else:
                    low = mid + 1

            return ans

    def findFlowers(self, nums, mid, k, m):
        count = 0
        curr_streak = 0
        
        for num in nums:
            if num <= mid:
                curr_streak += 1
                if curr_streak == k:
                    count += 1
                    curr_streak = 0
            else:
                curr_streak = 0
        
        return count
