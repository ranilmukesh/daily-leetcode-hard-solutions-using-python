class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int charCount[] = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }
        int left = 25, right = 25;
        StringBuilder sb = new StringBuilder();
        while (right >= 0) {
            int len = charCount[right];
            left = right - 1;
            if (len == 0) {
                right--;
                continue;
            }
            if (len > repeatLimit) {
                for (int i = 0; i < repeatLimit; i++) {
                    sb.append((char) (right + 'a'));
                }
                charCount[right] = charCount[right] - repeatLimit;
                if (right == 0) {
                    break;
                }
                while (left > 0 && charCount[left] == 0) {
                    left--;
                }
                if (charCount[left] == 0) {
                    break;
                }
                charCount[left] = charCount[left] - 1;
                sb.append((char) (left + 'a'));
            } else {
                for (int i = 0; i < len; i++) {
                    sb.append((char) (right + 'a'));
                }
                right--;
            }
        }
        return sb.toString();
    }
}
