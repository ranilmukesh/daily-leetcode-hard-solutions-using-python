class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;        
        int left = 0;
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == n - 1) 
            return 0;
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int minLen = 0;
        if(n - left - 1 < right)
            minLen = n - left - 1;
        else
            minLen = right;
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                if(minLen > j - i - 1)
                    minLen = j - i - 1;
                i++;
            }
            else {
                j++;
            }
        }
        return minLen;
    }
}
