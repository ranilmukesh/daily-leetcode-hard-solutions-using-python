class Solution:
    def minimumEffortPath(self, heights: List[List[int]]) -> int:
        last_row = len(heights) - 1
        last_column = len(heights[0]) - 1
        heap = [(0,0,0)]
        while True:
            effort, i, j = heappop(heap)
            height = heights[i][j]
            if height is None:
                continue
            if i == last_row and j == last_column:
                return effort
            heights[i][j] = None
            if i > 0:
                next_height = heights[i - 1][j]
                if next_height is not None:
                    next_effort = max(effort, abs(height - next_height))
                    heappush(heap, (next_effort, i - 1, j))
            if i < last_row:
                next_height = heights[i + 1][j]
                if next_height is not None:
                    next_effort = max(effort, abs(height - next_height))
                    heappush(heap, (next_effort, i + 1, j))
            if j > 0:
                next_height = heights[i][j - 1]
                if next_height is not None:
                    next_effort = max(effort, abs(height - next_height))
                    heappush(heap, (next_effort, i, j - 1))
            if j < last_column:
                next_height = heights[i][j + 1]
                if next_height is not None:
                    next_effort = max(effort, abs(height - next_height))
                    heappush(heap, (next_effort, i, j + 1))
