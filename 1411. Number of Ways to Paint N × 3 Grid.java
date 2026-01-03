class Solution {
    final int MOD = (int)1e9 + 7;
    public int numOfWays(int n) {
        return (int)solve(n-1, 6, 6);
    }

    long solve(long n, long uniques, long sandwiches){
        if(n == 0) return (uniques + sandwiches)%MOD;

        return solve(n - 1,
            ((uniques*2)%MOD + (sandwiches*2)%MOD)%MOD,
            ((uniques*2)%MOD + (sandwiches*3)%MOD)%MOD  
        );

    }
}
