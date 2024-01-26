class Solution:
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        
        @cache
        def fun(r, c, mov):
            if r<0 or r>=m or c<0 or c>=n: 
                return 1
            if mov <= 0:
                return 0
            temp = 0
            for i, j in [(-1,0),(1,0),(0,-1),(0,1)]:
                temp += fun(r+i, c+j, mov-1)
            return temp

        ans = fun(startRow, startColumn, maxMove)
        return ans % 1000000007
