class Solution {
    public int minimumDeletions(String s) {
        int i, aCount = 0, bCount = 0, len = s.length(), min = len;
        var chars = s.toCharArray();
        for (i = len - 1; i >= 0; i--) {
            aCount += 'b' - chars[i]; // if chars[i] == 'a' then aCount++;
        }
        for (i = 0; i < len; i++) {
            aCount += chars[i] - 'b'; // if chars[i] == 'a' then aCount--;
            min = Math.min(min, aCount + bCount);
            bCount -= 'a' - chars[i]; // if chars[i] == 'b' then bCount++;
        }
        return min;
    }
}
