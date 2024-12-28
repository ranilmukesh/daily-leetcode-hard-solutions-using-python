class Solution:
    def maxSumOfThreeSubarrays(self, nums: List[int], k: int) -> List[int]:
        w1, w2, w3 = sum(nums[0:k]), sum(nums[k:2*k]), sum(nums[2*k:3*k])
        maxw1, maxw2, maxw3 = w1, w1 + w2, w1 + w2 + w3

        maxw1index, maxw2index, maxw3index = [0], [0, k], [0, k, 2*k]

        for i in range(1, len(nums) - 3*k + 1):
            w1 += nums[i+k-1] - nums[i-1]
            w2 += nums[i+2*k-1] - nums[i+k-1]
            w3 += nums[i+3*k-1] - nums[i+2*k-1]

            if w1 > maxw1:
                maxw1, maxw1index = w1, [i]

            if maxw1 + w2 > maxw2:
                maxw2, maxw2index = maxw1 + w2, maxw1index + [i+k]

            if maxw2 + w3 > maxw3:
                maxw3, maxw3index = maxw2 + w3, maxw2index + [i+2*k]

        return maxw3index
