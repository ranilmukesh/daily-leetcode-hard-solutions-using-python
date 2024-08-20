class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSums = new int[n + 1];
        int[][] memo = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffixSums[i] = suffixSums[i + 1] + piles[i];
        }

        
        return getMaxStones(1, 0, suffixSums, memo);
    }

    private int getMaxStones(int M, int currentPile, int[] suffixSums, int[][] memo) {
        int n = suffixSums.length - 1;

       
        if (currentPile >= n) return 0;        
        if (memo[currentPile][M] != 0) return memo[currentPile][M];
        if (currentPile + 2 * M >= n) {
            return suffixSums[currentPile];
        }

        int maxStones = 0;

        for (int x = 1; x <= 2 * M; x++) {
            int nextPile = currentPile + x;
            int currentStones = suffixSums[currentPile] - getMaxStones(Math.max(M, x), nextPile, suffixSums, memo);
            maxStones = Math.max(maxStones, currentStones);
        }

        memo[currentPile][M] = maxStones;
        return maxStones;
    }
}
