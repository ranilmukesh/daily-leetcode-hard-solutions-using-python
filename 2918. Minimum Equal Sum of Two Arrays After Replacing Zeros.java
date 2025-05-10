// class Solution {
//     public long minSum(int[] nums1, int[] nums2) {
//         long nums1Zeroes = 0, nums2Zeroes = 0,sum1 = 0, sum2 = 0;
//         for(int i : nums1){
//             if(i == 0) nums1Zeroes++;
//             sum1 += i;
//         }

//         for(int i : nums2){
//             if(i == 0) nums2Zeroes++;
//             sum2 += i;
//         }

//         long min1 = sum1 + nums1Zeroes;
//         long min2 = sum2 + nums2Zeroes;

//         if(nums1Zeroes == 0 && nums2Zeroes == 0){
//             return sum1 == sum2 ? sum1 : -1;
//         }else if(nums1Zeroes == 0){
//             return sum2 + nums2Zeroes <=sum1 ?sum1 : -1;
//         }else if (nums2Zeroes == 0){
//             return sum1 + nums1Zeroes <= sum2 ? sum2 : -1;
//         }
//         return Math.max(min1, min2);
//     }
// }


class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long zeroCount1 = 0;

        for (int n: nums1) {
            sum1 += (long) n;
            zeroCount1 += n == 0 ? 1 : 0;
        }

        long sum2 = 0;
        long zeroCount2 = 0;

        for (int n: nums2) {
            sum2 += (long) n;
            zeroCount2 += n == 0 ? 1 : 0;
        }

        long minSum1 = sum1+zeroCount1;
        long minSum2 = sum2+zeroCount2;

        if (minSum1<minSum2 && zeroCount1 == 0) {
            return -1;
        }

        if (minSum1>minSum2 && zeroCount2 == 0) {
            return -1;
        }

        return Math.max(minSum1, minSum2);
    }
}
