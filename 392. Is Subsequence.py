class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:

        t = iter(t)
        
        return all(x in t for x in s)
