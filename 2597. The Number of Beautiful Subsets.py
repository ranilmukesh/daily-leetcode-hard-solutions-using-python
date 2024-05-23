class Solution:
    def beautifulSubsets(self, nums: List[int], k: int) -> int:       
        nums.sort() 
        def rec(i=0,blocked=[],empty=True):
            if i>=len(nums): return not empty
            while blocked and blocked[0]<nums[i]: blocked = blocked[1:] 
            if blocked and blocked[0]==nums[i]: return rec(i+1,blocked,empty) 
            return (rec(i+1,blocked,empty)+
                    rec(i+1,blocked+[nums[i]+k],False))
        return rec()
