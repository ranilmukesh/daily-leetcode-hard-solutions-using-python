class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n > m) return false;
        
        int[] exists = new int[26];
        
        //1.
        for(char c : s1.toCharArray()) {
            exists[c-'a']++;
        }

        int left = 0;
        int right = n;
        int[] diff = new int[26];
        //2.
        for(int i = left ; i < right ; i++) {
            diff[s2.charAt(i) - 'a']++;
        }

        while(right <= m) {
            //4.
            boolean result = same(exists, diff);
            if(result) {
                return true;
            }
            
            if(right==m) return false;

            //3.
            diff[s2.charAt(left++) - 'a']--;
            diff[s2.charAt(right++) - 'a']++;
        }

        return false;
    }

    public boolean same(int[] arr1, int[] arr2) {
        for(int i = 0 ; i < 26 ; i ++){
            if(arr1[i] == arr2[i]) continue;
            else return false;
        }
        return true;
    }
}
