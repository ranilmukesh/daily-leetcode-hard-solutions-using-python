class Solution {
    public int differenceOfSums(int n, int m) {
        int n1=0;
        for(int i=m;i<=n;i+=m)n1+=i;
        return n*(n+1)/2-2*n1;
    }
}
