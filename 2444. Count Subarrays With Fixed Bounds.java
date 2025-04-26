class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        badi = mini = maxi = -1
        ans = i = v = 0
        for num in nums:
            if minK > num or num > maxK:
                badi = i
            else:
                if num == minK: mini = i
                if num == maxK: maxi = i
                v= mini - badi if mini < maxi else maxi - badi
                if v > 0: ans += v
            i += 1
        return ans
