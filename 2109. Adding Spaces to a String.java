class Solution {
    public String addSpaces(String s, int[] spaces) {
        int j = 0;
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(j < spaces.length && spaces[j] == i) {
                ans.append(" ");
                j++;
            }
            ans.append(s.charAt(i));
        }

        return ans.toString();
    }
}
