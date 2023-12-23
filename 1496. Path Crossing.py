class Solution:
    def isPathCrossing(self, path: str) -> bool:

        visited = {gaussInt:= 0+0j}

        dir = {        'N':0+1j, 
               'W':-1+0j,      'E': 1+0j,
                       'S':0-1j}

        for step in path:

            gaussInt+= dir[step]
            if gaussInt in visited: return True

            visited.add(cNum)

        return False
