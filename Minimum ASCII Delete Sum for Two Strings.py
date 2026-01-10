class Solution:
    def minimumDeleteSum(self, s1: str, s2: str) -> int:
        len1, len2 = len(s1), len(s2)
        dp = [0] * (len2 + 1)

        for i in range(1, len1 + 1):
            dp_new = dp.copy()

            for j in range(1, len2 + 1):
                if s1[i - 1] == s2[j - 1]:
                    dp_new[j] = ord(s2[j - 1]) + dp[j - 1]
                else:
                    dp_new[j] = max(dp[j], dp_new[j - 1])
            
            dp = dp_new
        ascii1 = sum([ord(c) for c in s1])
        ascii2 = sum([ord(c) for c in s2])
        return ascii1 + ascii2 - (2 * dp[len2])
