class Solution
{
    public boolean hasAlternatingBits(int n)
    {
        int i,l=(int)(Math.log(n)/Math.log(2))+1;
        boolean s=(((1<<0)&n)>0);
        for(i=1;i<l;i++)
        {
            if((((1<<i)&n)>0)==s)
            return false;
            s=(((1<<i)&n)>0);
        }
        return true;
    }
}
