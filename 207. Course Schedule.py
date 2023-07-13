class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        courses = defaultdict(list)
        degree = [0] * numCourses
        visited = set()
        has_cycle = False

        for course, prereq in prerequisites:
            courses[prereq].append(course)
            degree[course] += 1

        queue = deque([x for x in range(numCourses) if degree[x] == 0])
        
        while queue:
            course = queue.popleft()
            if course in visited:
                has_cycle = True
                break
            visited.add(course)
            for neighbor in courses[course]:
                degree[neighbor] -= 1
                if degree[neighbor] == 0:
                    queue.append(neighbor)

        return not has_cycle and len(visited) == numCourses
