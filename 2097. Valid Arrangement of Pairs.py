from array import array
class Solution:
    def validArrangement(self, pairs: List[List[int]]) -> List[List[int]]:
        graph = defaultdict(lambda: array('I'))
        degree = defaultdict(int)
        for y, x in pairs:
            graph[x].append(y)
            degree[x] += 1
            degree[y] -= 1
        stack = array('I', [next((k for k in graph if degree[k]==1), x)])
        while (l := graph[stack[-1]]):
            stack.append(l.pop())
        prev = stack.pop()
        while stack:
            while (l := graph[stack[-1]]):
                stack.append(l.pop())
            yield (prev, (prev := stack.pop()))
