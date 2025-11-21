class Solution {
    public int countPalindromicSubsequence(String s) {
        char[] chars = s.toCharArray();
        
        int uniqueCharCount = 0;
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';
            
            if (first[c] == -1) {
                first[c] = i;
                uniqueCharCount++;
            }

            last[c] = i;
        }

        int count = 0;

        for (int c = 0; c < first.length; c++) {
            if (last[c] - first[c] < 2) {
                continue;
            }

            int subCount = 0;
            boolean[] isCharMet = new boolean[26];

            for (int i = first[c] + 1; i < last[c] && subCount < uniqueCharCount; i++) {
                int ch = chars[i] - 'a';

                if (!isCharMet[ch]) {
                    isCharMet[ch] = true;
                    subCount++;
                }
            }

            count += subCount;
        }

        return count;
    }
}
