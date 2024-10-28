class Solution {
    public int longestSquareStreak(int[] nums) {
        int rs = -1;
        boolean[] seq = new boolean[100001];
        for (int val : nums) {
            seq[val] = true;
        }

        for (int i = 2; i * i < seq.length; i++) {
            if (seq[i]) {
                int count = 0;
                int val = i; // inga overfllow um check pannanum
                while (val > 1 && val < seq.length && seq[val]) {
                    count++;
                    seq[val] = false;                    
                    val *= val;
                }

                if (count > 1) {
                    rs = Math.max(rs, count);
                }               
            }
        }

        return rs;
    }
}
