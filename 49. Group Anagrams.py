class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        return (a:={})or any(a.setdefault("".join(sorted(w)),[]).append(w) for w in strs) or a.values()
