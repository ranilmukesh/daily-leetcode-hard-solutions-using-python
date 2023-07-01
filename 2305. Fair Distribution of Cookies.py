class Solution:
    def distributeCookies(self, cookies: List[int], k: int) -> int:

        cookies.sort(reverse = True)

        N = len(cookies)

        best = 10**10

        def dfs(i, distribution):
            nonlocal best
            if N-i < distribution.count(0) or max(distribution) >= best:
                return

            if i == N:
                best = min(best, max(distribution))
                return

            for j in range(k):
                dfs(i + 1, tuple(x+cookies[i] if jj==j else x for jj,x in enumerate(distribution))) 
              
            return 
        
        dfs(0, tuple(0 for _ in range(k)))

        return best
