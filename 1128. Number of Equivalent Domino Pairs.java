class Solution
{
    public int numEquivDominoPairs(int[][] d)
    {
        int[] h = new int[81];
        int c = 0;
        
        for(int [] dom : d)
            c += h[((dom[0]<dom[1]) ? 9*(dom[0]-1)+dom[1] : 9*(dom[1]-1)+dom[0])-1]++;
        
        return c;
    }
}
