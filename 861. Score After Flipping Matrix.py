class Solution:
    def matrixScore(self, G: List[List[int]]) -> int:
        G, M, N = list(zip(*[[b^g[0]^1 for b in g] for g in G])), len(G), len(G[0])
        return sum(max(sum(g),M-sum(g))*2**(N-i-1) for i,g in enumerate(G))
