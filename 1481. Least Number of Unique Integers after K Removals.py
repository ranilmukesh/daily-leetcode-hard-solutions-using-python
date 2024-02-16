import heapq
class Solution:
    def findLeastNumOfUniqueInts(self, arr: List[int], k: int) -> int:
        freq = {}
        for n in arr:
            if n not in freq:
                freq[n] = 0
            freq[n] += 1
        
        freq_arr = list( freq.values() )
        heapq.heapify(freq_arr)
        # print(freq_arr)
        while k >=0 or len(freq_arr) > 0:
            last_num = heapq.heappop(freq_arr)
            # print(freq)
            if k > last_num:
                k -= last_num
            elif k == last_num:
                return len(freq_arr)
            else:
                return len(freq_arr) + 1

        return 0
