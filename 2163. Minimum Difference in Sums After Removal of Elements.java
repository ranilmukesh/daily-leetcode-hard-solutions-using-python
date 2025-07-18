class Solution:
    def minimumDifference(self, V: List[int]) -> int:
        n = len(V)//3
        H = [-v for v in V[:n]]
        heapify(H)
        P = [-sum(H)]  
        for v in V[n: 2*n]:
            p = P[-1]
            if -v > H[0]:
                p -= -heappop(H)
                heappush(H, -v)
                p += v
            P.append(p)
        H = [v for v in V[2*n:]]
        heapify(H)
        S = [sum(H)]               
        for v in V[2*n-1: n-1: -1]:
            s = S[-1]
            if v > H[0]:
                s -= heappop(H)
                heappush(H, v)
                s += v
            S.append(s)
        S = S[::-1]
        return min(p-s for p,s in zip(P,S))
