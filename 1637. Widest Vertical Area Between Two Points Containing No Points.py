class Solution:
    def maxWidthOfVerticalArea(self, points: List[List[int]]) -> int:
        xcordinates = [i[0] for i in points]
        xcordinates.sort()

        maxdif = 0

        for i in range(len(xcordinates) -1):
            dif = xcordinates[i+1] - xcordinates[i]
            maxdif = max(maxdif, dif)
            
        return maxdif
