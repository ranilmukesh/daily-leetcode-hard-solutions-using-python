class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        for(int i = 0; i< s.length()-1; i++) {
            char c = s.charAt(i);
            sum += Math.abs(c - s.charAt(i+1));     
        }
        return sum;

    }
}
