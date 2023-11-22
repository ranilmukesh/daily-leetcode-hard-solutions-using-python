class Solution:
    def findDiagonalOrder(self, nums: List[List[int]]) -> List[int]:
        m, n = len(nums), max(map(len, nums))
        diags = [[] for _ in range(m + n - 1)]
        for i in range(m - 1, -1, -1):
            for j, num in enumerate(nums[i]):
                diags[i + j].append(num)
        return [num for diag in diags for num in diag]
