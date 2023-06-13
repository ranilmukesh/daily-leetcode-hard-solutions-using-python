class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda x:[x[1],-x[2],x[1]])
        done=[]
        for a,b,c in tasks:
            for a1,b1 in done[::-1]:
                if(b1>=a and c!=0):
                    c=max(c-(b1-max(a1,a)+1),0)
                else:
                    break
            if(c!=0):
                done.append([b-c+1,b])
                i=len(done)-1
                j=i-1
                while(j>=0):
                    if(done[j][1]>=done[i][0]):
                        r=done[j][1]-done[i][0]+1
                        done[i][0]+=r
                        done[j][0]-=r
                    else:
                        break
                    i-=1
                    j-=1
        totalTime=0
        for a,b in done:
            totalTime+=(b-a+1)
        return totalTime
