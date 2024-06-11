class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int cnt[] = new int[1001], ans[] = new int[arr1.length], i = 0;
        for (int j : arr1)    cnt[j]++;
        for (int n : arr2) {
            while (cnt[n] > 0) {
                ans[i++] = n;
                cnt[n]--;
            }
        }
        for (int j = 0; j < 1001; j++) {
            while (cnt[j] > 0) {
                ans[i++] = j;
                cnt[j]--;
            }
        }
        return ans;
    }
}
