class Solution:
    def getSumAbsoluteDifferences(self, nums: List[int]) -> List[int]:
        lsum, rsum, length = 0, sum(nums), len(nums)
        ans = []

        for i, num in enumerate(nums):
            # ans.append((num * i - lsum) + (rsum - num * (length - i)))
            ans.append(rsum - lsum + num * (i + i - length))
            lsum += num
            rsum -= num

        return ans
