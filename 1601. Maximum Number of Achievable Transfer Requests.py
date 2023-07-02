class Solution:
    def maximumRequests(self, n: int, r: List[List[int]]) -> int:
        same=0
        req=[]
        #if both moving to same building
        for i in r:
            if i[0]==i[1]:same+=1
            else:req.append(i)
        ans=0
        for i in range(len(req)+1):
            for combs in list(itertools.combinations(req,i)):
                if combs:
                    temp=[0]*n
                    for at in combs:
                        temp[at[0]]+=1
                        temp[at[1]]-=1
                    if set(temp)=={0}:
                        print(combs)
                        ans=max(ans,len(combs))
        return ans+same
