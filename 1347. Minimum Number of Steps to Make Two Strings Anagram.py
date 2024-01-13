class Solution:
    def minSteps(self, s: str, t: str) -> int:
        a=Counter(s)
        b=Counter(t)
        count=0
        for i,c in a.items():
            count+=max(0,c-b.get(i,0))
        return count 
