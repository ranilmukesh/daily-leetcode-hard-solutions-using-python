MAXN = 10**5+5
pf = list(range(MAXN + 1))

def sieve():
    p = 2
    while p * p <= MAXN:
        if pf[p] == p:
            for i in range(p * p, MAXN + 1, p):
                pf[i] = p
        p += 1
    return pf

@cache
def fact(n):
    ans = set()
    while n>1:
        f = pf[n]
        ans.add(f)
        while n%f == 0:
            n //= f
    return ans
    
class Solution:
    def canTraverseAllPairs(self, nums: List[int]) -> bool:
        global MAXN
        n = len(nums)
        MAXN = max(nums)+2

        pf = sieve()
        g = defaultdict(set)

        for num in nums:
            if num == 1: return len(nums) == 1
            factors = fact(num)
            for f in factors:
                g[f].update(factors)
        
        seen = set()

        def dfs(at):
            if at in seen: return
            seen.add(at)
            for to in g[at]:
                dfs(to)
        
        dfs(pf[nums[0]])
        return len(g) == len(seen)
