class Solution {
    public int maxTwoEvents(int[][] e) {
        int n = e.length;
        Arrays.sort(e, (a, b) -> a[0] - b[0]);
        int[] sMax = new int[n];
        sMax[n - 1] = e[n - 1][2];
        
        for (int i = n - 2; i >= 0; --i) {
            sMax[i] = Math.max(e[i][2], sMax[i + 1]);
        }
        
        int mSum = 0;
        
        for (int i = 0; i < n; ++i) {
            int l = i + 1, r = n - 1;
            int nIdx = -1;
            
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (e[mid][0] > e[i][1]) {
                    nIdx = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            
            if (nIdx != -1) {
                mSum = Math.max(mSum, e[i][2] + sMax[nIdx]);
            }
            mSum = Math.max(mSum, e[i][2]);
        }
        
        return mSum;
    }
}
