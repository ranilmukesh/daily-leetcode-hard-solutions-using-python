class Solution:
    def frequencySort(self, s: str) -> str:
        return "".join(starmap(mul,sorted(Counter(s).items(),key=itemgetter(1),reverse=True)))
