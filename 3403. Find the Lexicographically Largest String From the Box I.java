// class Solution {
//     public String answerString(String word, int numFriends) {
//         if (numFriends == 1) return word;

//         int n = word.length();
//         int len = n - numFriends + 1;
//         char maxChar = 'a';

//         for (char ch : word.toCharArray()) {
//             if (ch > maxChar) maxChar = ch;
//         }

//         String result = "";
//         for (int i = 0; i < n; i++) {
//             if (word.charAt(i) == maxChar) {
//                 if (i + len <= n) {
//                     String sub = word.substring(i, i + len);
//                     if (sub.compareTo(result) > 0) result = sub;
//                 } else {
//                     String sub = word.substring(i);
//                     if (sub.compareTo(result) > 0) result = sub;
//                 }
//             }
//         }

//         return result;
//     }
// }


class Solution {

    public String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }

    public String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String last = lastSubstring(word);
        int n = word.length(), m = last.length();
        return last.substring(0, Math.min(m, n - numFriends + 1));
    }
}
