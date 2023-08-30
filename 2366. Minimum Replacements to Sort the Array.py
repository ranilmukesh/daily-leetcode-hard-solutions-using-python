class Solution:
    def minimumReplacement(self, nums):
        n, total, prev = len(nums), 0, nums[-1]

        for i in range(n-2,-1,-1):
            d = math.ceil(nums[i]/prev)
            total += d-1
            prev = nums[i]//d

        return total
