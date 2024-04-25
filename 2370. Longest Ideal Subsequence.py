class Solution:
    def longestIdealString(self, s: str, k: int) -> int:
        dp = [0]*123
        for symbol in s:
            symbol = ord(symbol)
            dp[symbol] = max(dp[symbol-k:symbol+k+1])+1
        return max(dp)
