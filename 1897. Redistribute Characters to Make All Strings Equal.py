class Solution:
    def makeEqual(self, words: List[str]) -> bool:
        a = ''.join(words)
        s = set(a)
        for i in s :
            if a.count(i) % len(words) != 0 : return False
        return True
        
