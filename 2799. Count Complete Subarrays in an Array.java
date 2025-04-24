class Solution {
    public int countCompleteSubarrays(int[] nums) {
        final int n = nums.length;
        boolean[] exist = new boolean[2001];
        int[] numCnt = new int[2001];
        int l = 0, r = 0, ans = 0;
        int whDistCnt = 0, distCnt = 0;

        for (int num:nums) {
            if (false == exist[num]) {
                exist[num] = true;
                whDistCnt++;
            }
        }

        for (; l < n; ++l) {
            while (r < n && distCnt < whDistCnt) {
                if (++numCnt[nums[r++]] == 1) distCnt++;
            }

            if (distCnt == whDistCnt) ans += n - r + 1;
            else if (r == n && distCnt < whDistCnt) break;

            if (--numCnt[nums[l]] == 0) distCnt--;
        }

        return ans;
    }
}
