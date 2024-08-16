class Solution:
    def maxDistance(self, arrays: List[List[int]]) -> int:
        small, large = float('inf'), -float('inf')
        small_idx, large_idx = -1, -1
        n = len(arrays)

        for i in range(n):
            if arrays[i][0] < small:
                small = arrays[i][0]
                small_idx = i
            if arrays[i][-1] > large:
                large = arrays[i][-1]
                large_idx = i
        
       
        if large_idx != small_idx: return arrays[large_idx][-1] - arrays[small_idx][0]

       
        second_small, second_large = float('inf'), -float('inf')
        second_small_idx, second_large_idx = -1, -1
        for i in range(n):
            if i == small_idx: continue
            if arrays[i][0] < second_small:
                second_small = arrays[i][0]
                second_small_idx = i
            if arrays[i][-1] > second_large:
                second_large = arrays[i][-1]
                second_large_idx = i
        
       
        return max(arrays[second_large_idx][-1] - arrays[small_idx][0],
                   arrays[large_idx][-1] - arrays[second_small_idx][0])
