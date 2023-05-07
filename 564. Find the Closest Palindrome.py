class Solution:
    def nearestPalindromic(self, S):
        N = len(S)
        Val = lambda x: abs(int(S) - int(x)) 
        P = int(S[:(N + 1) >> 1])
        Dp = [i + (i[:len(i)-(N&1)])[::-1] for i in map(str, range(P - 1, P + 2))] + ['1' + '0'*(N-1) + '1']
        ans = '9' * (N - 1) or '0'
        for i in Dp:
            if not (i.startswith('00') or i == S) and Val(i) < Val(ans):
                ans = i
        return ans
