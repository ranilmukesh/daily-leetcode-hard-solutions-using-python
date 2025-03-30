class Solution
{
    String s;
    int [] l;
    
    public List<Integer> partitionLabels(String s)
    {
        this.s = s;
        l = new int[26];
        int n = s.length();

        for(int i=0, x=0; i<n; i++)
            l[s.charAt(i)-'a'] = i;

        List<Integer> r = new ArrayList<>();

        for(int cl=0, cr=0; cl<n; cl=cr+1)
        {
            cr = getRightMost(cl, l[s.charAt(cl)-'a']);
            r.add(cr-cl+1);
        }

        return r;
    }

    private int getRightMost(int f, int g)
    {
        for(int i=f; i<g; i++)
            g = Math.max(g, l[s.charAt(i)-'a']);

        return g;
    }
}
