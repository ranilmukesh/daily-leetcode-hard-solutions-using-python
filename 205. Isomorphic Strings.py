class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        return len(set(t)) == len(set(s)) == len(set(zip(s,t)))
