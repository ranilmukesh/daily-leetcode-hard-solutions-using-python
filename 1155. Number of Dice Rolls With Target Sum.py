MOD = 1000000007

# Number of combinations
C_:List[List[int]] = [[1] for _ in range(1001)]
for n in range(1,1001):
    for r in range(1,min((n+1)//2,31)):
        C_[n].append((C_[n-1][r] + C_[n-1][r-1]) % MOD) # nCr
    if n%2==0 and (n+1)//2<=30:
        C_[n].append((C_[n-1][(n+1)//2-1] * 2) % MOD) # nC((n+1)//2)
def C(n:int,r:int):
    return C_[n][r] if r<n//2+1 else C_[n][n-r]

class Solution:
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        ans = 0
        for i in range(n+1):
            if target-k*i<n:
                break
            elif i%2==0:
                ans += C(n,i) * C(target-k*i-1,n-1)
            else:
                ans -= C(n,i) * C(target-k*i-1,n-1)
            # print(i,target-k*i-n,ans)
            ans %= MOD
        return ans
