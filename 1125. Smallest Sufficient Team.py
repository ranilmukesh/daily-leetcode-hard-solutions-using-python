class Solution:
    def smallestSufficientTeam(self, req_skills, people):
        n = len(req_skills)

        dict1 = {skill:i for i,skill in enumerate(req_skills)}

        ans = [reduce(lambda x,y: x|(1<<y),[dict1[i] for i in skills],0) for skills in people]

        @lru_cache(None)
        def dfs(i,mask):
            if mask == (1<<n) - 1: return []
            if i == len(ans): return [0]*60
            return min(dfs(i+1,mask), [i] + dfs(i+1,mask|ans[i]), key = len)

        return dfs(0,0)
