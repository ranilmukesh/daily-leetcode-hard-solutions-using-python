class Solution {
    public boolean check(int[]colors,int i, int  k)
    {
        int n=colors.length;
        int red=colors[i%n];
        int blue= colors[(i+1)%n];
        if(red==blue) return  false;
        int last=i+k-1;
        for(int j =i+2;j<=last;j+=2)
        {
            if(red!=colors[j%n])
            {
                return false;
            }
        }  
        for(int j=i+3;j<=last;j+=2)
        {

            if(blue!=colors[j%n])
            {
                return false;
            }
        }
        //System.out.println("i ran");
        return true;
    }
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n =colors.length;
        //find first valid sequence
        int idx=-1;
        int grps=0;
        for(int i=0;i<n;i++)
        {
            if(check(colors,i,k))
            {
                grps+=1;
                idx=i;
                break;
            }
        }
        //System.out.println("i ranil");
        if(idx==-1)
        {
            return 0;
        }
        boolean evenFlag= k%2==0 ? true : false;
        for(int i=idx+1;i<n;i++)
        {
            if(!evenFlag && colors[i]==colors[(i+k-1)%n])
            {
                grps+=1;
               System.out.println("same "+ grps+" i-> "+i);
            }
            else if (evenFlag && colors[i]!=colors[(i+k-1)%n])
            {
                grps+=1;
            } 
            else
            {
                int temp=i;
                int j =i+k-1;
                for(j = j;j<n;j++)
                {
                    if(check(colors,j,k))
                    {
                        grps+=1;
                        i=j;
                        break;
                    }
                }
                if(temp==i) return grps;
                System.out.println(i+" else");
                //i-=1;
            }
        }
        return grps;
    }
}
