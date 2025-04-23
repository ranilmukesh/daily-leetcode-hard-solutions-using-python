// // class Solution {
// //     public int countLargestGroup(int n) {
// //         int[] sums = new int[37];
// //         for (int i = 1; i <= n; i++) sums[digsum(i)]++;

// //         int maxi = 0, count = 0;
// //         for (int i : sums) {
// //             if (i > maxi) {
// //                 maxi = i;
// //                 count = 1;
// //             } else if (i == maxi) {
// //                 count++;
// //             }
// //         }
// //         return count;
// //     }

// //     private int digsum(int n) {
// //         int sum = 0;
// //         while (n > 0) {
// //             sum += n % 10;
// //             n /= 10;
// //         }
// //         return sum;
// //     }
// // }


// class Solution {
//     public int countLargestGroup(int n) {
//         Map<Integer, Integer> mpp = new HashMap<>();
//         int maxi = 0, count = 0;

//         for (int i = 1; i <= n; i++) {
//             int x = digsum(i);
//             mpp.put(x, mpp.getOrDefault(x, 0) + 1);
//             maxi = Math.max(maxi, mpp.get(x));
//         }

//         for (int val : mpp.values()) if (val == maxi) count++;
//         return count;
//     }

//     private int digsum(int n) {
//         int sum = 0;
//         while (n > 0) {
//             sum += n % 10;
//             n /= 10;
//         }
//         return sum;
//     }
// }


class Solution {
    int[][] ref = { {1}, new int[10], new int[19], new int[28] };
    
    public int countLargestGroup(int n) {
        int[] digits = {1,0,0,0}, counts = new int[37];
        int power = 0, psum = 0;
        for (int num = Math.min(n, 9999); num > 0; num /= 10)
            psum += digits[power++] += num % 10;
        for (int d = 0; d < power; d++) {
            int digit = digits[d], prevSize = ref[d].length;
            int currSize = d > 2 || ref[d + 1][ref[d + 1].length - 1] > 0 ? 0 : ref[d + 1].length;
            int limit = Math.max(d * 9 + digit, currSize);
            psum -= digit;
            for (int i = 0, val = 0; i < limit; i++) {
                val += (i < prevSize ? ref[d][i] : 0)
                     - (i >= digit && i - digit < prevSize ? ref[d][i - digit] : 0);
                counts[psum + i] += val;
                if (currSize > 0)
                    ref[d + 1][i] = (i > 0 && i - 1 < currSize ? ref[d + 1][i - 1] : 0)
                            + (i < prevSize ? ref[d][i] : 0)
                            - (i >= 10 && i - 10 < prevSize ? ref[d][i - 10] : 0);
            }
        }
        counts[0] = 0;
        int count = 0, max = 0;
        for (int x : counts)
            if (x > max) {
                max = x;
                count = 1;
            } else if (x == max)
                count++;
        return count;
    }
    }
