class Solution:
    def countPalindromicSubsequence(self, s: str) -> int:
        @lru_cache(maxsize=None)
        def isRightOf(char, ind):
            return char in s[ind:]
        @lru_cache(maxsize=None)
        def where(char, ind):
            try:
                return s[ind:].index(char) + ind
            except ValueError:
                return 'not'
        a = 'abcdefghijklmnopqrstuvwxyz'
        ans = 0
        for i in a:
            r = where(i, 0)
            if r == 'not':
                continue
            for k in a:
                r2 = where(k, r+1)
                if r2 == 'not':
                    continue
                if isRightOf(i, r2+1):
                    ans += 1
        return ans
