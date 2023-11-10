class Solution:
    def restoreArray(self, adjacentPairs: List[List[int]]) -> List[int]:
        
        adj_list = defaultdict(list)
        for a, b in adjacentPairs:
            adj_list[a].append(b)
            adj_list[b].append(a)
        
        root = None
        for node in adj_list:
            if len(adj_list[node]) == 1:
                root = node
                break
        
        stack = [root]
        visited = set([root])
        res = [root]
        while stack:
            node = stack.pop()
            for nbr in adj_list[node]:
                if nbr not in visited:
                    res.append(nbr)
                    stack.append(nbr)
                    visited.add(nbr)
                    break
        return res
