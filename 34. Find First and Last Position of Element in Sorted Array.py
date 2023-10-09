class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        try:
            pos = nums.index(target)
        except ValueError:
            return [-1, -1]

        end = pos
        
        for i in range(pos, len(nums)):
            if nums[i] == target:
                end = i
                continue
            break

        return [pos, end]
