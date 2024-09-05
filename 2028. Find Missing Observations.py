class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int res[]=new int[n];
        int sum=0,rem_sum,total=rolls.length+n;
        for( int i:rolls)
        {
            sum+=i;
        }
        rem_sum=mean*total-sum;
        if(rem_sum>6*n||rem_sum<n) return new int[]{};
        
        int avg=rem_sum/n,remainder=rem_sum%n;
        for(int i=0;i<remainder;i++)
        {
            res[i]=avg+1;
        }
        for(int i=remainder;i<n;i++)
        {
            res[i]=avg;
        }
        return res;
    }
}
