class Solution {
  public long maximumValueSum(int[] nums, int k, int[][] edges) {
    long sum = 0;
    int increaseCount = 0, correction = Integer.MIN_VALUE;

    for (int num : nums) {
      int xored = num ^ k;
      sum += num;      
      int diff = xored - num;
      if (diff > 0) {
        correction = Math.max(correction, -diff);
        sum += diff;
        increaseCount++;
      } else correction = Math.max(correction, diff);
    }

    if ((increaseCount & 1) == 0) return sum;

    return sum + correction;
  }
}
