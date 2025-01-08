class Solution {
    public boolean isPrefixAndSuffix(String str1,String str2){
        int n1=str1.length();
        int n2 = str2.length();
        if(n1>n2)return false;
        for(int i=0;i<n1;i++){
            if(str1.charAt(i)!=str2.charAt(i) || str1.charAt(i)!=str2.charAt(n2-n1+i))return false;
        }
        return true;
    }
    public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(isPrefixAndSuffix(words[i],words[j]))cnt++;
            }
        }
        return cnt;
        
    }
}
