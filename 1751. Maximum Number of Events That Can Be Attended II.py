import bisect
from functools import lru_cache

class Solution:
    def maxValue(self, events: List[List[int]], k: int) -> int:
        if k == 1:
            return max([event[2] for event in events])
        
        events.sort()
        event_starts = [event[0] for event in events]
        
        @lru_cache(None)
        def dp(i, j):
            if j == 0: 
                return 0
            if i >= len(events):
                return 0
            max_score = events[i][2]
            
            next_index_minimum = bisect.bisect_left(event_starts, events[i][1] + 1)
            for k in range(next_index_minimum, len(events)):
                max_score = max(max_score, events[i][2] + dp(k, j - 1))
            
            max_score = max(max_score, dp(i + 1, j))
            return max_score
        return dp(0, k)
