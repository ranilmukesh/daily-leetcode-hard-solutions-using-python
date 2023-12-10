class Solution:
    def transpose(self, matrix: List[List[int]]) -> List[List[int]]:
        m = len(matrix)
        n = len(matrix[0])
        temp = []
        for i in range(n):
            temp1 = []
            for j in range(m):
                temp1.append(matrix[j][i])
            
            temp.append(temp1)
        
        return temp
