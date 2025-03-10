class Solution {
    public long countOfSubstrings(String word, int k) {
        int n = word.length();
        int[] suf = new int[n + 1];
        int[] farr = new int[26];
        int si = 0;
        long ans = 0;
        suf[n] = n;
        for (int i = n - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (!isVowel(ch)) {
                suf[i] = i;
            } else {
                if (i == n - 1)
                    suf[i] = n;
                else
                    suf[i] = suf[i + 1];
            }
        }
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (!isVowel(ch))
                k -= 1;
            else
                farr[ch - 'a'] += 1;
            while (k < 0) {
                if (!isVowel(word.charAt(si)))
                    k += 1;
                else
                    farr[word.charAt(si) - 'a'] -= 1;
                si += 1;
            }
            while (check(farr) && k == 0) {
                ans += (suf[i + 1] - i);
                if (!isVowel(word.charAt(si)))
                    k += 1;
                else
                    farr[word.charAt(si) - 'a'] -= 1;
                si += 1;
            }
        }
        return ans;
    }

    public boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }
        return false;
    }

    public boolean check(int[] farr) {
        return farr['a' - 'a'] > 0 && farr['e' - 'a'] > 0 && farr['i' - 'a'] > 0
                && farr['o' - 'a'] > 0 && farr['u' - 'a'] > 0;
    }
}
