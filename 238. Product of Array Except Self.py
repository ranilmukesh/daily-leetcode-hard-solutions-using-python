class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        def product(nums,i):
            a=1
            for j in range(len(nums)):
                if i==j:
                    continue
                if nums[j]==0:
                    return 0
                else:
                    a=a*nums[j]
            return a     
        d={}
        res=[]
        for i in range(len(nums)):
            if nums[i] not in d:
                d[nums[i]]=product(nums,i)
            res.append(d[nums[i]])
        return res
                
