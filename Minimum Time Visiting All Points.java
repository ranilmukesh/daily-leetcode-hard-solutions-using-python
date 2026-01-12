class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        for(int i=0;i<points.length-1;i++){
            ans+=sol(points[i],points[i+1]);
        }
        return ans;
    }
    public int sol(int[] a,int[] b){
        int x=Math.abs(a[0]-b[0]);
        int y=Math.abs(a[1]-b[1]);
        return Math.max(x,y);
    }
}
