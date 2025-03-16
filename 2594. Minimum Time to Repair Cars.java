class Solution {
    private int[] freq=new int[101];
    private boolean check(int[] ranks,int cars,long mid){
        long x=0;
        for(int i=1;i<=100;i++) x+=freq[i]*Math.floor(Math.sqrt(mid/i));
        return x>=cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long low=1,high=Integer.MAX_VALUE;
        for(int rank:ranks){
            high=Math.min(high,rank);
            freq[rank]++;
        }
        high*=1l*cars*cars;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(check(ranks,cars,mid)) high=mid-1;
            else low=mid+1;
        }
        return low;
    }
}
