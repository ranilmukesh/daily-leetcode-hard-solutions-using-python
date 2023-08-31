class Solution:
    def minTaps(self, n: int, ranges: List[int]) -> int:
        covers = [(i-ranges[i], i+ranges[i]) for i in range(n+1)]
        covers.sort()
        
        start, end = -1000, 0
        cnt = 0
        i = 0
        while i<=n and end < n:
            find = False
            _max = end
            while i<=n and start <= covers[i][0] <= end:
                _max = max(_max, covers[i][1])
                i = i+1
                find = True
            
            if not find: return -1
            start, end = end, _max
            cnt += 1
        
        if end < n: return -1
        return cnt
