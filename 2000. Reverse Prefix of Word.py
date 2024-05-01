class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        if word.find(ch) != -1:
           return word[:word.find(ch)+1][::-1]+word[word.find(ch)+1:]
        else:
               return word
