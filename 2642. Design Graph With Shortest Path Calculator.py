class Graph:

    def __init__(self, n, edges):
        self.dict1 = defaultdict(list)
        self.n = n

        for i,j,c in edges:
            self.dict1[i].append((j,c))

    def addEdge(self, edge):
        self.dict1[edge[0]].append((edge[1],edge[2]))

    def shortestPath(self, node1, node2):
        stack, dist = [(0,node1)], [float("inf")]*self.n

        dist[node1] = 0

        while stack:
            c, node = heappop(stack)

            for neighbor,cost in self.dict1[node]:
                if cost + c < dist[neighbor]:
                    dist[neighbor] = cost + c
                    heapq.heappush(stack,(cost+c,neighbor))

        return dist[node2] if dist[node2] != float("inf") else -1






        
