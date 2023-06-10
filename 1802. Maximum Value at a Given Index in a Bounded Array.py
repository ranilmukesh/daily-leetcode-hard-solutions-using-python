class Solution:
    def maxValue(self, n: int, index: int, maxSum: int) -> int:
        def getval(m,val):
            if m<=0:return 0
            if val<=m:
                return (val*(val+1)//2) + max(0,m-val)
            else:
                return (val*(val+1)//2) - ((m-val-1)*(m-val))//2

        def isvalid(v):
            score=v
            a=getval(index,v-1)
            b=getval(n-index-1,v-1)
            score+=a+b
            if score<=maxSum:
                nonlocal ans
                ans=max(ans,v)
                return True
            return False

        ans=0
        l=1
        r=10**9
        while(l<=r):
            mid=(l+r)//2
            if isvalid(mid):
                l=mid+1
            else:
                r=mid-1
        isvalid(18)
        return ans
