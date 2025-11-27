class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);
        minPrefix[0] = 0L;
        long prefixSum = 0L;
        long maxSum = Long.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            int rem = (i + 1) % k;
            if (minPrefix[rem] != Long.MAX_VALUE) {
                maxSum = Math.max(maxSum, prefixSum - minPrefix[rem]);
            }
            minPrefix[rem] = Math.min(minPrefix[rem], prefixSum);
        }
        return maxSum;
    }

    public long maxSubarraySumBruteForce(int[] nums, int k) {
        int n = nums.length;
        int low = k;
        int high = n - (n % k);
        long maxSum = Long.MIN_VALUE;
        
        for (int len = low; len <= high; len += k) {
            maxSum = Math.max(maxSum, maxSubArraySumOfLength(nums, n, len));
        }
        return maxSum;
    }

    private long maxSubArraySumOfLength(int[] nums, int n, int targetLength) {
        long maxSum = Long.MIN_VALUE;
        long sum = 0L;
        int i = 0;
        
        for (int j = 0; j < n; j++) {
            sum += nums[j];
            if (j - i + 1 == targetLength) {
                maxSum = Math.max(maxSum, sum);
                sum -= nums[i];
                i++;
            }
        }
        return maxSum;
    }
}
