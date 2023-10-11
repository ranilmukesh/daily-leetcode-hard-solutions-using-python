class Solution:
    def fullBloomFlowers(self, flowers: List[List[int]], people: List[int]) -> List[int]:
        add = sorted([i[0] for i in flowers])[::-1]
        minus = sorted([i[1] for i in flowers])[::-1]

        d = {}
        ssum = 0
        for i in sorted(people):
            while add and i >= add[-1]:
                add.pop()
                ssum += 1
            while minus and  i > minus[-1]:
                minus.pop()
                ssum -= 1
            d[i] = ssum
        
        return [d[i] for i in people]
