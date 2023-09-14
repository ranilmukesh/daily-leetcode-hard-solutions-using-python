class Solution(object):
    def findItinerary(self, tickets):
        graph = defaultdict(list)
        for src, dst in tickets:
            graph[src].append(dst)
        for src in graph.keys():
            graph[src].sort()
        itinerary = []
        def dfs(src):
            while graph[src]:
                neighbor = graph[src].pop(0)
                dfs(neighbor)
            itinerary.append(src)
        dfs("JFK")
        return itinerary[::-1]
