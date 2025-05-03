class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int ans=a(tops,bottoms,tops[0]);
        if(tops[0]!=bottoms[0]){
            ans=Math.min(ans,a(tops,bottoms,bottoms[0]));
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public int a(int[]t,int[]b,int tar){
        int c=0,co=0;
        for(int i=0;i<t.length;i++){
            if(t[i]!=tar && b[i]!=tar)return Integer.MAX_VALUE;
            if(t[i]!=tar)c++;
            if(b[i]!=tar)co++;
        }
        return Math.min(c,co);
    }
}
