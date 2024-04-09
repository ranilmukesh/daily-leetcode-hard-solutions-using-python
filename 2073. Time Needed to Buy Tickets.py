class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        count = tickets[k]
        for i in tickets[:k]:
            count+=min(i, tickets[k])
        for i in tickets[k+1:]:
            count+=min(i, tickets[k]-1)
        return count
        
