class Solution
{
    public int binaryGap(int n)
    {
        int m = 0;

        for(int i=0, p=-1; n>0; i++, n /= 2)
            if(n%2==1)
            {
                if(p!=-1)
                    m = Math.max(m,i-p);
                
                p = i;
            }

        return m;
    }
}
