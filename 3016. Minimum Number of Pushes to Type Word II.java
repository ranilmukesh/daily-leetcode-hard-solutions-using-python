class Solution
{
    public int minimumPushes(String word)
    {
        int [] a = new int[26];

        for(int i=0, l=word.length(); i<l; i++)
            a[word.charAt(i)-'a']++;

        Arrays.sort(a);

        int r = 0;

        for(int i=25, v=1, x=0; i>=0 && a[i]>0; i--)
        {
            r += v*a[i];

            if(x==7)
            {
                x=0;
                v++;
            }

            else
                x++;
        }

        return r;
    }
}
