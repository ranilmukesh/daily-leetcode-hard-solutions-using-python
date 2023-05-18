class Solution:
    def findSmallestSetOfVertices(self, n, edges):
        all_nodes = set(range(n))
        destination_nodes = set(destination for _, destination in edges)
        source_nodes = all_nodes - destination_nodes
        return list(source_nodes) #ranilmukesh - GitHub
