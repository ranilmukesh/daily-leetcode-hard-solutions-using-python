class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        d = sorted(deck, reverse = True)
        q = deque([d[0]])
        for i in range(1,len(d)):
            x=q.pop()
            q.appendleft(x)
            q.appendleft(d[i])
        return q
