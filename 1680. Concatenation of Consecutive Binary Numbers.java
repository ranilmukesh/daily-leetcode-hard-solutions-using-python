class Solution {
    public int concatenatedBinary(int n) {

        long res=0, mod=1000000007;
        int bits=0;
        for(int i=1;i<=n;i++)
        {
           // bits=1;
            if((i&(i-1))==0)
            bits++;
            res= ((res<<bits)+i)%mod;
        }
        return (int)res;
        // StringBuilder str= new StringBuilder();
        // for(int i=1;i<=n;i++)
        // {
        //     int temp=i;
        //     StringBuilder tempStr= new StringBuilder();
        //     while(temp>0)
        //     {
        //         int last= temp&1;
        //         tempStr.append(last);
        //         temp=temp>>1;
                
        //     }
        //     str.append(tempStr.reverse());
        // }
        // String out= str.toString();
        // long num= Long.parseLong(out,2);
        // System.out.println("num "+num);
        // int ans= (int)(num%1000000007);
        // return ans;
        
    }
}
