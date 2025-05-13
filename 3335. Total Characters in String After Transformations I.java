// class Solution {
//     private static final long mod = 1000000007;
//     private long mod_add(long a, long b) {
//         a %= mod; b %= mod;
//         return ((a + b) % mod + mod) % mod;
//     }
//     public int lengthAfterTransformations(String s, int t) {
//         long[] nums = new long[26];
//         for (char ch : s.toCharArray()) nums[ch - 'a']++;
//         while (t-- > 0) {
//             long[] cur = new long[26];
//             for (int j = 0; j < 26; j++) {
//                 if (j == 25 && nums[j] > 0) {
//                     cur[0] = mod_add(cur[0], nums[j]);
//                     cur[1] = mod_add(cur[1], nums[j]);
//                 } else {
//                     if (j < 25) cur[j + 1] = mod_add(cur[j + 1], nums[j]);
//                 }
//             }
//             nums = cur;
//         }
//         long cnt = 0;
//         for (long i : nums) cnt = mod_add(cnt, i);
//         return (int) cnt;
//     }
// }



class Solution {
    public int lengthAfterTransformations(String s, int t) {
    	int MOD = (int)1e9 + 7, ans = 0;
        long[] count = new long[26];
        for (int c : s.toCharArray())
        	count[c - 'a']++;
        for (; t >= 26; t -= 26) {
        	long z = count[25];
        	for (int i = 25; i > 0; i--)
        		count[i] = (count[i] + count[i - 1]) % MOD;
        	count[0] = (count[0] + z) % MOD;
        	count[1] = (count[1] + z) % MOD;
        }
        for (int i = 0; i < 26; i++)
        	ans = (int)((ans + count[i]) % MOD);
        for (int i = 26 - t; i < 26; i++)
        	ans = (int)((ans + count[i]) % MOD);
        return ans;
    }
}
