public final class Solution {

    private static final int ODD_VOWELS_SIZE;
    private static final int[] vowelBitTable;

    public static int findTheLongestSubstring(String s) {
        int oddVowels = 0;
        int[] oddVowelsBeginIndices = new int[ODD_VOWELS_SIZE];

        int maxLength = 0;
        int beginIndex = 0;
        int n = s.length();
        for (int endIndex = 0; endIndex < n; ) {
            // Get the vowel bit for the next char.
            int c = s.charAt(endIndex);
            int vowelBit = vowelBitTable[c];

            // Skip if the next char is a consonant.
            if (vowelBit == 0) {
                endIndex++;
                continue;
            }

            // Calculate the length based on the first occurrence of this combo of vowels.
            int length = endIndex - beginIndex;
            maxLength = Math.max(maxLength, length);

            // Process the next vowel.
            endIndex++;
            oddVowels ^= vowelBit;

            // Get or set the first occurrence of this combo of odd vowels.
            beginIndex = oddVowelsBeginIndices[oddVowels];
            if ((beginIndex == 0) && (oddVowels != 0)) {
                beginIndex = endIndex;
                oddVowelsBeginIndices[oddVowels] = beginIndex;
            }
        }

        // Process the entire string.
        int length = n - beginIndex;
        return Math.max(maxLength, length);
    }

    static {
        ODD_VOWELS_SIZE = 0x20;
        vowelBitTable = new int[123];
        vowelBitTable['a'] = 0x01;
        vowelBitTable['e'] = 0x02;
        vowelBitTable['i'] = 0x04;
        vowelBitTable['o'] = 0x08;
        vowelBitTable['u'] = 0x10;
    }
}
