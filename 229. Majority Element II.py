class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        return (counts := collections.Counter(nums), [num for num in counts if counts[num] > len(nums) /3])[1]
