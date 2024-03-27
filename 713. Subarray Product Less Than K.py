class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        left,right,count,product,n=0,0,0,1,len(nums)
        if k<=1:
            return 0
        while right<n:
            product*=nums[right]
            while product>=k:
                product//=nums[left]
                left+=1
            count+=1+(right-left)
            right+=1

        return count
                

