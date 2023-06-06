class Solution(object):
    def canMakeArithmeticProgression(self, arr):
        arr.sort()  # Sort the list in ascending order

        common_diff = arr[1] - arr[0]  # Calculate the common difference

        for i in range(2, len(arr)):
            if arr[i] - arr[i - 1] != common_diff:
                return False  # If the difference is not equal to the common difference, return False

        return True  # All differences are equal, so return True
