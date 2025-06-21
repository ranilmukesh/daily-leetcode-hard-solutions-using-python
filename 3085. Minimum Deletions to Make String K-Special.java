class Solution {
    public int minimumDeletions(String word, int k) {
        int n = word.length(), res = n, freq[] = new int[26];
        for(int i = 0; i < n; i++)  freq[word.charAt(i) - 'a']++;
        for(int i = 0; i < 26; i++){
            if(freq[i] == 0)    continue;
            int currRes = 0;
            for(int j = 0; j < 26; j++){
                if(freq[j] == 0 || i == j)        continue;
                else if(freq[j] < freq[i])        currRes += freq[j];
                else if(freq[j] - freq[i] > k)    currRes += Math.min(freq[j], freq[j] - freq[i] - k); 
            }
            res = Math.min(res, currRes);
        }
        return res;
    }
}
