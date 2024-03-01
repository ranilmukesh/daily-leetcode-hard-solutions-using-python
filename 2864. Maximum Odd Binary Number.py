class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        sorted_s = sorted(s, reverse=True)
        ans = ''.join(sorted_s[1:])+sorted_s[0]
        return ans
