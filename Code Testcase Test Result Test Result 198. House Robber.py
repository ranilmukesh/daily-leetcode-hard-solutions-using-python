from typing import List

class Solution:
    def rob(self, arr: List[int]) -> int:
        n = len(arr)

        if n == 0:
            return 0
        elif n == 1:
            return arr[0]

        prev, curr = arr[0], max(arr[0], arr[1])

        for i in range(2, n):
            prev, curr = curr, max(curr, prev + arr[i])

        return curr
