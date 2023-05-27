class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        stoneValue.reverse()
        n = len(stoneValue)
 
        dp = [float('-inf') for i in range(n)]
        prev = []
        total = 0
        for v in stoneValue:
            total += v
            prev.append(total)
            
        for i in range(n):
            # special case that I can grab all stones
            if i in [0, 1, 2]:
                curr = sum(stoneValue[:i + 1])
                dp[i] = curr
            for n in [1, 2, 3]:
                if i >= n:
                    curr = sum(stoneValue[i - n + 1:i + 1])
                    dp[i] = max(dp[i], prev[i - n] - dp[i - n] + curr)

        res = dp[len(stoneValue) - 1]
        if res * 2 > total:
            return 'Alice'
        elif res * 2 == total:
            return 'Tie'
        else:
            return 'Bob'
