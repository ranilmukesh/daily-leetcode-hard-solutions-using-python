class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        ans = 0
        dp = {}
        for word in sorted(words, key=len):
            dp[word] = max(
                dp.get(word[:i] + word[i + 1 :], 0) + 1 for i in range(len(word))
            )
            ans = max(ans, dp[word])
        return ans
