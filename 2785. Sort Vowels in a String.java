class Solution {
    public String sortVowels(String s) {
        int len = s.length();
        char[] res = new char[len];
        char[] vowels = new char[len];
        int numVow = 0;

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'A' || c == 'U' || c == 'u' || c == 'o' || c == 'O' || c == 'E' || c == 'e' || c == 'i' || c == 'I') {
                vowels[numVow] = c;
                numVow++;
            } else {
                res[i] = c;
            }
        }
        Arrays.sort(vowels, 0, numVow);

        int j = 0;
        for (int i = 0; i < len; i++) {
            if (res[i] == '\u0000') {
                res[i] = vowels[j++];
            }
        }
        return new String(res);
    }
}
