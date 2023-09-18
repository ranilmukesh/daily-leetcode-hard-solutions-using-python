class Solution:
    def kWeakestRows(self, mat: List[List[int]], k: int) -> List[int]:
        row_strength = [(sum(mat[i]), i) for i in range(len(mat))]
        row_strength.sort()
        return [row[1] for row in row_strength[:k]]
