class DisjointSet:
    def __init__(self, n):
        self.node2root = {i:i for i in range(n)}
        self.node2rank = {i:0 for i in range(n)}
    
    def find(self, node):
        if self.node2root[node] != node:
            self.node2root[node] = self.find(self.node2root[node])
        return self.node2root[node]
    
    def union(self, node1, node2):
        root1 = self.find(node1)
        root2 = self.find(node2)
        if root1 == root2:
            return False
        rank1 = self.node2rank[root1]
        rank2 = self.node2rank[root2]
        if rank1 <= rank2:
            self.node2root[root1] = root2
            self.node2rank[root2] += (rank1 == rank2)
        else:
            self.node2root[root2] = root1
        return True

class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        ds = DisjointSet(n)
        critical = []
        pseudo_critical = []

        Edge = namedtuple('Edge', ['ind', 'src', 'dst', 'weight'])
        sorted_edges = [Edge(i, *edge) for i, edge in enumerate(edges)]
        sorted_edges.sort(key=lambda e: e.weight)
        for weight, same_weight_edges in itertools.groupby(sorted_edges, key=lambda e: e.weight):
            graph = defaultdict(set)
            etype2edges = defaultdict(list)
            for edge_ind, s, d, w in same_weight_edges:
                root1 = ds.find(s)
                root2 = ds.find(d)
                if root1 != root2:  # criteria 1
                    graph[root1].add(root2)
                    graph[root2].add(root1)
                    etype = f'{min(root1, root2)}<->{max(root1, root2)}'
                    etype2edges[etype].append(edge_ind)
            for etype, interchangeable_edges in etype2edges.items():
                root1, root2 = map(int, etype.split('<->'))
                if len(interchangeable_edges) > 1 or self.edge_in_cycle(root1, root2, graph):  # criteria 2
                    for edge in interchangeable_edges:
                        pseudo_critical.append(edge)
                else:
                    critical.append(interchangeable_edges[0])
                ds.union(root1, root2)
        return [critical, pseudo_critical]

    def edge_in_cycle(self, src, dst, graph):
        graph[src].remove(dst)
        graph[dst].remove(src)
        still_has_path = self.find(src, dst, graph, set())
        graph[src].add(dst)
        graph[dst].add(src)
        return still_has_path

    def find(self, node, target, graph, seen):
        if node == target:
            return True
        if node in seen:
            return False
        seen.add(node)
        for neigh in graph[node]:
            if self.find(neigh, target, graph, seen):
                return True
        return False
