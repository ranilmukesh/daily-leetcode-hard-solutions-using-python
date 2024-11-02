class Solution {
    public boolean isCircularSentence(String str) {
        int i=0;
        if(str.charAt(str.length()-1)!=str.charAt(0)) return false;
        while(i<str.length()){
            char ch=str.charAt(i);
            while(i<str.length()-1&&ch!=' '){
                i++;
                ch=str.charAt(i);
            }
            if(i<str.length()-1&&str.charAt(i-1)!=str.charAt(i+1)) return false;
            i++;
        }
        return true;
    }
}
