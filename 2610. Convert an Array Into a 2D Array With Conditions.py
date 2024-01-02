class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        freq = {}
        for num in nums:
            freq[num] = freq.get(num, 0) + 1
        max_freq = 0
        result = []
        for value in freq.values():
            max_freq = max(value, max_freq)
        for i in range(max_freq):
            temp = []
            for key, value in freq.items():
                if value > 0:
                    temp.append(key)
                    freq[key] -= 1
            result.append(temp)
        return result
