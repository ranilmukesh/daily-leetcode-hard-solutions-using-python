class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n=values.length;
        int max=values[n-1]-n+1;
        int res=0;
        for(int i=n-2;i>=0;i--)
        {
            if((max+values[i]+i)>res)
                res=max+values[i]+i;
            if((values[i]-i)>max)
                max=values[i]-i;
        }
        return res;
    }
}
