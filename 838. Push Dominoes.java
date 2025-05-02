class Solution {
    public String pushDominoes(String s) {
        char[] a=s.toCharArray();
        char l='n',r='n';
        int i=0,c=0;
        while(i<s.length()){
            while(i<s.length() && a[i]!='.')i++;

            l=i==0?'n':a[i-1];
            int j=i;
            while(j<s.length() && a[j]=='.') j++;
            r= j>=s.length()?'n':a[j];
            j--;
            
            if(l=='R' && r=='L'){
                while(i<j){
                    a[i++]='R';
                    a[j--]='L';
                }
                i++;
            }
            else if(l=='R')
                while(i<=j) a[i++]='R';
            else if(r=='L')
                while(i<=j) a[i++]='L';
            else i=j+1;
            l='n';
            r='n';
        }
        return new String(a);
    }
}
