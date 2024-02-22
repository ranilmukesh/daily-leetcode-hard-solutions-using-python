class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        d=[1]*n
        c=[0]*n
        for i,j in trust:
            d[i-1]=0
            c[j-1]+=1
        
        for i in range(n):
            if d[i]==1 and c[i]==n-1:
                return i+1
        return -1
