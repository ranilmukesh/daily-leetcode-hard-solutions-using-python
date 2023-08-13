class Solution:
    def validPartition(self, nums: List[int]) -> bool:
        r0 = 1
        r1 = b2 = c2 = 0

        prev = None
        for num in nums:
            if prev == num:
                r0, r1, b2, c2 = (r1 or b2), r0, r1, False
            elif prev == num-1:
                r0, r1, b2, c2 = c2, r0, False, r1
            else:
                r1 = r0
                r0 = b2 = c2 = False
            prev = num

        return r0
