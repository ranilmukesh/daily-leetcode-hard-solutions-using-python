class Solution:
  def paintWalls(self, cost, time):
    kMax = 500000000
    n = len(cost)
    dp = [0] + [kMax] * n

    for c, t in zip(cost, time):
      for walls in range(n, 0, -1):
        dp[walls] = min(dp[walls], dp[max(walls - t - 1, 0)] + c)

    return dp[n]
