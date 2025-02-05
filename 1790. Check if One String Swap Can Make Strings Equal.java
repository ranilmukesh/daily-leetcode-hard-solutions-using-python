class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;

        int swap1 = 0, swap2 = 0;
        int count = 0;
        boolean result = false;

        for (int i =0; i< s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                if (count==0){
                swap1 = s1.charAt(i);
                swap2 = s2.charAt(i);
                }else if (count== 1 && swap1 == s2.charAt(i) && swap2 == s1.charAt(i)){
                    result = true;
                }else{
                    result =false;
                }
                count++;
            } 
        }
        return result;
    }
}
