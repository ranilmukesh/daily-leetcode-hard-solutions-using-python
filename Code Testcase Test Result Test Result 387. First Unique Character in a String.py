class Solution:
    def firstUniqChar(self, s: str) -> int:
        dic={}
        for i in range(len(s)):
            a=s[i]
            if(a in dic):
                dic[a].append(i)
            else:
                dic[a]=[i]
        mn=None
        for a in dic:
            if(len(dic[a])==1):
                if(mn==None):
                    mn=dic[a][0]
                else:
                    mn=min(dic[a][0],mn)
        if(mn!=None):
            return mn
        else:
            return -1
