from collections import defaultdict
class Solution:
    def sumPrefixScores(self, words: List[str]) -> List[int]:
        hashmap = defaultdict(int)
        for word in words:
            prefix = ""
            for letter in word:
                prefix += letter
                hashmap[prefix] += 1
        res = [0]*len(words)
        for i in range(len(words)):
            word = words[i]
            prefix = ""
            for letter in word:
                prefix += letter
                res[i] += hashmap[prefix]
        return res
