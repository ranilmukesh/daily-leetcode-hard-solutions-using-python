class Solution {
    public int candy(int[] ratings) {
       int candy = ratings.length;
       int n=ratings.length;
       int i=1;
       while(i<n)
       {
         if(ratings[i]==ratings[i-1])
        {
            i++;
            continue;
        }

        int peak=0;
        while(ratings[i]>ratings[i-1])
        {
            peak++;
            candy+=peak;
            i++;

            if(i==n)
            return candy;
        }
        int diff=0;
        while(i<n && ratings[i]<ratings[i-1])
        {
            diff++;
            candy+=diff;
            i++;
        }

        candy -= Math.min(diff,peak);
       }
       return candy;
    }
}
