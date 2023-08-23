class Solution:
    def reorganizeString(self, s: str) -> str:
        charCounter=Counter(s)
        heap=[]
        for key,val in charCounter.items():
            heapq.heappush(heap,(-val,key))
        out=''
        while heap:
            countA,keyA=heapq.heappop(heap)
            if heap:
                countB,keyB=heapq.heappop(heap)
                out+=keyA+keyB
                if -countA>1:
                    heapq.heappush(heap,(countA+1,keyA))
                if -countB>1:
                    heapq.heappush(heap,(countB+1,keyB))
            else:
                if -countA>1:
                    return ""
                else:
                    out+=keyA
        return out
