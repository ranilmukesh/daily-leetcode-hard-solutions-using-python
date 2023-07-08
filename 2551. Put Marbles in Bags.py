class Solution:
    def putMarbles(self, A, K):
        if K == 1: return 0
        B = sorted([A[i] + A[i + 1] for i in range(len(A) - 1)])
        return sum(B[-K+1:]) - sum(B[:K-1])
