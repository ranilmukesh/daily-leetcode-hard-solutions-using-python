class Solution {
    public int numTilings(int n) {
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        if(n==3) return 5;
        int modd= 1000000007;
        long f1=1;
        long f2=2;
        long f3=5;
        for(int i=4;i<=n;i++){
            long ans=(f3*2+f1)%modd;
            f1=f2;
            f2=f3;
            f3=ans;
        }

        return (int)f3;
    }
}
