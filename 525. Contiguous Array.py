class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        w = 17
        real = 1
        pos = ((1 << w) - 1) << 1
        neg = pos << w

        s = 0
        ans = 0
        for i, n in enumerate(nums):
            s += 2*(n & real) - 1

            if s == 0:
                ans = i+1
            elif s < 0:
                f = ((nums[s] & neg) >> (w+1)) - 1
                if f >= 0:
                    ans = max(ans, i-f)
                else:
                    nums[s] |= (i+1) << (w+1)
            else:
                f = ((nums[s-1] & pos) >> 1) - 1
                if f >= 0:
                    ans = max(ans, i-f)
                else:
                    nums[s-1] |= (i+1) << 1

        return ans
