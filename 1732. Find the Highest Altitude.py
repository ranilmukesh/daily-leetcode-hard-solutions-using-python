class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        return max(*accumulate(gain), 0)
