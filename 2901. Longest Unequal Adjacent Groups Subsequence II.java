class Solution {
    public List<String> getWordsInLongestSubsequence(String[] w, int[] g) {
        int[] p = new int[w.length];
        int[] s = new int[w.length];
        p[p.length-1]=p.length-1;
        s[s.length-1]=1;

        int max=1, mi=w.length-1;
        for(int i=w.length-2; i>=0; i--){
            p[i]=i; s[i]=1;
            for(int j=i+1; j<w.length; j++){
                if(s[i]>s[j]
                || !con(w, i, j, g))continue;
                p[i]=j; s[i]=s[j]+1;
            }
            if(max<s[i]){max=s[i]; mi=i;}
        }


        List<String> ret = new ArrayList<>();
        ret.add(w[mi]);
        while(p[mi]!=mi){
            mi=p[mi];
            ret.add(w[mi]);
        }
        return ret;
    }
    private boolean con(String[] w, int i, int j, int[] g){
        if(g[i]==g[j]||w[i].length()!=w[j].length()){
            return false;
        }
        boolean x=false; char c1,c2;
        for(int k=0; k<w[i].length(); k++){
            c1=w[i].charAt(k);
            c2=w[j].charAt(k);
            if(c1!=c2){
                if(x)return false;
                x=true;
            }
        }
        return x;
    }
}
