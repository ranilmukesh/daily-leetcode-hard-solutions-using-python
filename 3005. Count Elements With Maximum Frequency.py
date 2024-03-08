class Solution(object):
    def maxFrequencyElements(self, nums):
        dic={}
        mx=0
        count=0
        flag=0
        for i in range(len(nums)):
            if nums[i] in dic.keys():
                flag=1
                dic[nums[i]]+=1
                if dic[nums[i]]>mx:
                    mx=dic[nums[i]]
                    count=1
                elif dic[nums[i]]==mx:
                    count+=1
            else:
                dic[nums[i]]=1
        if flag==1:
            return mx*count
        else:
            return len(nums)
