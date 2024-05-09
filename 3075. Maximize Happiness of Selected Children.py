class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        
        happiness = sorted(happiness)
        min_ind = 0
        s = happiness[-k:]
        for i in range(len(s)-2, -1, -1):
            if s[i] - (len(s)-1-i)>=0:
                s[i] = s[i] - (len(s)-1-i)
            else:
                min_ind = i+1
                break
        return sum(s[min_ind:])
