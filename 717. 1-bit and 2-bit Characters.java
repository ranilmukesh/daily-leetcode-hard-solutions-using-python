class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n=bits.length;
        if(n==1)return true;
        if(bits[bits.length-2]==0)return true;
        int ct=0;
        for(int i=n-2;i>=0 && bits[i]==1;i--){
            ct++;
        }
        return ct%2==0;
    }
}
