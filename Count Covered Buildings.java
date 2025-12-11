class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] colMin = new int[n + 1], colMax = new int[n + 1];
        int[] rowMin = new int[n + 1], rowMax = new int[n + 1];
        Arrays.fill(colMin, Integer.MAX_VALUE);
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        Arrays.fill(colMax, Integer.MIN_VALUE);
        Arrays.fill(rowMax, Integer.MIN_VALUE);
        for (int[] building : buildings) {
            int r = building[0], c = building[1];
            colMin[c] = Math.min(colMin[c], r);
            colMax[c] = Math.max(colMax[c], r);
            rowMin[r] = Math.min(rowMin[r], c);
            rowMax[r] = Math.max(rowMax[r], c);
        }
        int res = 0;
        for (int[] building : buildings) {
            int r = building[0], c = building[1];
            if (r > colMin[c] && r < colMax[c] && c > rowMin[r] && c < rowMax[r]) {
                res++;
            }
        }
        return res;
    }
}
