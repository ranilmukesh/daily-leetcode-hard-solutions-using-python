class Solution {
    public long flowerGame(int n, int m) {
        long oddPairX =0;
        long evenPairX = 0;
        long oddPairY = 0;
        long evenPairY = 0;
        if(n % 2== 0){
            oddPairX = n/2;
        } else {
            oddPairX = (n+1)/2;
        } 
        evenPairX = n - oddPairX;
        oddPairY = m/2;
        evenPairY = m-oddPairY;

        return oddPairX*oddPairY + evenPairX*evenPairY;                  
    }
}
