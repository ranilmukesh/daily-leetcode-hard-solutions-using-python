class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if len(intervals) <= 1:
            return 0
        intervals.sort(key = lambda x : x[1])
        first_end = intervals[0][1]
        result = 0
        for i in range(1, len(intervals)):
            start, end = intervals[i]
            if start >= first_end:
                first_end = end
            else:
                result += 1
        return result
