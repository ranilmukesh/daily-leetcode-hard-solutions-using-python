class Solution: 
    def minExtraChar(self, s: str, dictionary: List[str]) -> int:

        words = defaultdict(list)
        for word in dictionary: words[word[0]].append(word)

        @lru_cache(1000)  
        def dp(ptr:int)-> int:

            if ptr == len(s): return 0

            cands = (w for w in words[s[ptr]] if s[ptr:].startswith(w))
            return min([dp(ptr+len(w)) for w in cands]+[1+dp(ptr+1)])

        return dp(0)
