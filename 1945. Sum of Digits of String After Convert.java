class Solution {
    public int getLucky(String s, int k) {
        int res = 0;
        int[] sums = new int[26];
        for(int i = 0; i < 26; i++) {
            sums[i] = getSumOfDigits(i + 1);
        }
        for(char ch : s.toCharArray()) {
            res += sums[ch - 'a'];
        }
        while(k > 1 && res >= 10) {
            res = getSumOfDigits(res);
            k--;
        } 
        return res;
    }

    private int getSumOfDigits(int num) {
        int sum = 0;
        while(num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
