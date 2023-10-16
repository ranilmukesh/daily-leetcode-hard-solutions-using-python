class Solution:
    def getRow(self, rowIndex: int) -> list[int]:
        l,t,j=[[1,],[1,1]],0,1
        while t<rowIndex and j<len(l):    
            k=[1,1]
            for b in range(j):k.insert(1,0)
            for i in range(len(k)):
                if k[i]==0:k[i]=l[j][i-1]+l[j][i] 
            l.append(k)
            t,j=t+1,j+1
        return l[rowIndex]  
        
