class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        lpr = [i.count("1") for i in bank if i.count("1") > 0]
        if len(lpr) <= 1: return 0
        n = 0
        for i in range(0, len(lpr)-1):
            n += lpr[i] * lpr[i+1]
        return n
