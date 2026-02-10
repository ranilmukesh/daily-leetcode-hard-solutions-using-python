class Solution {
    private final int MAX_VAL = (int)1e5+1;
    private final int EVEN = 0;
    private final int ODD = 1;
    // seen[x] stores the "visit id" of the last subarray
    // (identified by its left index l) in which value x appeared.
    // If seen[x] == vid  → x has appeared in the current subarray nums[l..r]
    // If seen[x] != vid  → x has NOT appeared since this l started
    int[] seen = new int[MAX_VAL]; 
    int[] distinct = new int[2];
    
    public int longestBalanced(int[] nums) {
        final int n = nums.length;
        int maxLen = 0; 
        int vid = 0; // vid uniquely identifies the current left boundary l.
        
        for (int l = 0; l < n; ++l) {
            // Prune: remaining length cannot beat the current answer
            if (maxLen >= n - l) break;
            ++vid;
            distinct[EVEN] = distinct[ODD] = 0;
            for (int r = l; r < n; ++r) {
                int x = nums[r];
                if (seen[x] != vid) {
                    seen[x] = vid;
                    ++distinct[x & 1];
                }

                if (distinct[EVEN] == distinct[ODD]) {
                    maxLen = Math.max(maxLen, r-l+1);
                }
            }
        }

        return maxLen;
    }
}
