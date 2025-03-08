class Solution {
    public int minimumRecolors(String blocks, int k) {
        char c[]=blocks.toCharArray();
        int count=0;
        for(int i=0;i<k;i++)
        {
            if(c[i]=='B')
            count++;

        }
        int start=0;;
        int  end=k;
        int max=count;
        while(end<c.length)
        {
            if(c[start]=='B')
            count--;
            if(c[end]=='B')
            count++;
            start++;
            end++;
            max=Math.max(count,max);
             
        }
       
        if(max>=k)
        return 0;
        else
        return 
        k-max;
    }
}
