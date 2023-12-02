class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        return sum(len(w) for w in words if all(w.count(l) <= chars.count(l) for l in w))
