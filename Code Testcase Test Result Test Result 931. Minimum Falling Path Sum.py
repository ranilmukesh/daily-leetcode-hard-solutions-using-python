class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        ans = 101*n
        for i in range(1,n):
            for j in range(n):
                if j == 0:
                    matrix[i][j] += min(matrix[i-1][j+1],matrix[i-1][j])
                elif j == n-1:
                    matrix[i][j] += min(matrix[i-1][j],matrix[i-1][j-1])
                else:
                    matrix[i][j] += min(matrix[i-1][j-1],matrix[i-1][j+1],matrix[i-1][j])
        for j in range(n):
            ans = min(ans,matrix[n-1][j])
        return ans
