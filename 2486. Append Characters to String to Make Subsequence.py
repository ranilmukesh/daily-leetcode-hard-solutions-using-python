class Solution {
    public int appendCharacters(String s, String t) {
        int j=0,i=0,n=s.length(),m=t.length();
        char arr1[]= s.toCharArray();
        char arr2[]= t.toCharArray();
        for(i=0;i<n;i++){
            if(j>=m)return 0;
            if(arr1[i]==arr2[j])j++;
        }
        return m-j;

    }
}
