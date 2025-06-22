class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();
        int tot=(n%k==0)?n/k:(n/k)+1;
        String[] res=new String[tot];
        int i=0,index=0;
        while(i+k<n){
            String sub=s.substring(i,i+k);
            res[index++]=sub;
            i+=k;
        }
        StringBuilder rem=new StringBuilder();
        if(i!=n)
        rem.append(s.substring(i,n));
        while(rem.length()!=k)
        rem.append(fill);

        if(rem.length()>0)res[index]=rem.toString();

        return res;
        
    }
}
