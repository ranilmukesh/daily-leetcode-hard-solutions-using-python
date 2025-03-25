class Solution {
    public boolean checkValidCuts(int n, int[][] r) {
        return a(r,0) || a(r,1);
    }
    public boolean a(int[][]r,int i){
        int c=0;
        Arrays.sort(r,(a,b)->a[i]-b[i]);
        int prev=r[0][i+2];
        for(int j=1;j<r.length;j++){
            if(prev<=r[j][i]){
                c++;
            }
            prev=Math.max(prev,r[j][i+2]);
        }
        return c>=2;
    }
}
