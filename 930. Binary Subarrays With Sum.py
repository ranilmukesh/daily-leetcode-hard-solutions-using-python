class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        data ={0:1}
        total = 0
        count = 0
        for i in nums:
            total+=i
            if total-goal in data:
                count+= data[total-goal]
            if total in data:
                data[total]+=1
            else:
                data[total ] =1
        return count
