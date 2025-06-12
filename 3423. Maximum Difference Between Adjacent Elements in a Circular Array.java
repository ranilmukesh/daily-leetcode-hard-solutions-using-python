class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int i=0; i<n-1; i++) {
            max = Math.max(max,Math.abs(nums[i]-nums[i+1]));
        }
        max = Math.max(max,Math.abs(nums[0]-nums[n-1]));
        return max;
    }
}
