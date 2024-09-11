class Solution {
    public int minBitFlips(int start, int goal) {
        int xorResult = start^goal;
        return countSetBits(xorResult);
    }
    public int countSetBits(int n){
        if(n == 0)
        {
            return 0;
        }
        else 
        {
            return (n & 1) + countSetBits( n >> 1);
        }

    }
}
