class Solution {
   public int minPatches(int[] nums, int n) {
    long maxReach = 0;
    int patches = 0;
    int i = 0;
    long newN = (long) n;

    while (maxReach < newN) {
        if (i < nums.length && nums[i] <= maxReach + 1) {
            maxReach += nums[i++];
        } else {
            maxReach += maxReach + 1;
            patches++;
        }
    }

    return patches;
}

}
