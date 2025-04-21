class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        int c=(lower+upper)/2;
        int s=c,l=c;
        for(int n:differences){
            c=c+n;
            l=Math.max(l,c);
            s=Math.min(s,c);
        }
        if(l>upper&&s<lower){
            return 0;
        }
        if(l>=upper){
            s-=l-upper;
            l-=l-upper;
        }
        else{
            s+=upper-l;
            l+=upper-l;
            
        }
        return s>=lower?(s-lower)+1:0;
    }
}
