
class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length, lo = Integer.MAX_VALUE, hi = 0;
        for(int i : nums) {
            lo = Math.min(lo, i);
            hi = Math.max(hi, i);
        }

        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int housesRobbed = 0;
            
            for(int i = 0; i < n; ++i) {
                if(nums[i] <= mid) {
                    housesRobbed++;
                    i++;
                }
            }

            if(housesRobbed >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }
}
