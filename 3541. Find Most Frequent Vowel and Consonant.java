class Solution {
    public int maxFreqSum(String s) {
        int hash[] = new int[26];
        for(char ch: s.toCharArray()){
            hash[ch - 'a']++;
        }

        int ans = 0;
        int idx[] = {'a' - 'a', 'e' - 'a', 'i' - 'a', 'o' - 'a', 'u' - 'a'};
        for(int i=0;i<5;i++) ans = Math.max(ans, hash[idx[i]]);
        int maxi = 0;
        for(int i=0;i<26;i++){
            if(i != 0 && i != 4 && i != 8 && i != 14 && i != 20) maxi = Math.max(maxi, hash[i]);
        }
        return ans + maxi;
    }
}
