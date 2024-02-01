class Solution:
    def divideArray(self, nums: List[int], k: int) -> List[List[int]]:
        nums.sort()
        ans=[]
        # curr=[]
        i=0
        j=3
        n=len(nums)
        flag=True
        while j<=n:
            if(nums[j-1]-nums[i]<=k):
                ans.append(list(nums[i:j]))
            else:
                flag=False
                break
            i=j
            j+=3
        if(flag):
            return ans
        else:
            return []
        # return ans
