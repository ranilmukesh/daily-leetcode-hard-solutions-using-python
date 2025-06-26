class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        long value = 0,power = 1;
        int count = 0;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '0'){
                count++;
            }
            else if(value + power <= k){
                value = value + power;
                count++;
            }
            power = Math.min(power * 2,(long) k + 1);
        }
        return count;
    }
}
