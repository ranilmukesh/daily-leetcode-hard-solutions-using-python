class Solution:
    def champagneTower(self, poured: int, query_row: int, query_glass: int) -> float:
        dp = [poured]
        for i in range(query_row):
            a = [0] * (len(dp) + 1)
            for j in range(len(dp)):
                b = dp[j] - 1
                if b<=0: continue
                a[j] += b/2
                a[j+1] += b/2
            dp = a
        return 1 if dp[query_glass] >= 1 else dp[query_glass]
                
