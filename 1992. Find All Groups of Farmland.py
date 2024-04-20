class Solution:
    def findFarmland(self, land: List[List[int]]) -> List[List[int]]:

        row = len(land)
        col = len(land[0])
        ans = []

        def dfs(i,j):
            nonlocal ii, jj
            if i<0 or j<0 or i>=row or j >= col or land[i][j]==0:
                return 
            land[i][j]=0
            if i>ii:
                ii=i
            if j>jj:
                jj=j
            
            dfs(i+1,j)
            dfs(i,j+1)
            

        for i in range (row):
            for j in range (col):

                if land[i][j] == 1:
                    ii=-1
                    jj=-1
                    dfs(i,j)
                    ans.append([i,j,ii,jj])
        return ans

        

        
