class Solution
{
    public int minSwaps(int[][] grid)
    {
        int n = grid.length;
        int [] r = new int[n];

        for(int i=0; i<n; i++)
            r[i] = lastOne(grid[i]);

        int c = 0;

        for(int i=0, k=-1; i<n; i++, k=-1)
        {
            for(int j=i; j<n; j++)
                if(r[j]<=i)
                {
                    c += j - i;
                    k = j;
                    break;
                }

            if(k==-1)
                return -1;
            
            for(int j=k; j>i; j--)
                swap(r,j,j-1);
        }

        return c;
    }

    private int lastOne(int [] r)
    {
        for(int i=r.length-1; i>-1; i--)
            if(r[i]==1)
                return i;

        return -1;
    }

    private void swap(int [] r, int i, int j)
    {
        int t = r[i];
        r[i] = r[j];
        r[j] = t;
    }
}
