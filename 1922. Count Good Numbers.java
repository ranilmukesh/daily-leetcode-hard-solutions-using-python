class Solution {
    static int mod =(int)(1e9)+7;
    public int countGoodNumbers(long n) {
        long  even=n/2+n%2;
        long  odd=n/2;
        long ans=power(5,even);
        long ans1=power(4,odd);
        return (int)((ans*ans1) % mod);
    }
    public long power(long num,long k)
    {
     
        if(k==0)
        return 1;

        long ans=power(num,k/2);
        ans*=ans;
        ans%=mod;

        if(k%2!=0)
        ans*=num;
        ans%=mod;
        return ans;
    }
}
