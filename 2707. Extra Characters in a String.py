class Solution:
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:
        @cache
        def get_min_extra(i: int):
            if i == len(s):
                return 0
            res = 1 + get_min_extra(i + 1)
            for word in dictionary:
                if word == s[i:i + len(word)]:
                    res = min(res, get_min_extra(i + len(word)))
            return res
        
        return get_min_extra(0)
