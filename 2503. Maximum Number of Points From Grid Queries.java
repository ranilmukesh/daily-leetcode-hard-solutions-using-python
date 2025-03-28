public class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[] maxPoints(int[][] grid, int[] queries) {
        int qLen = queries.length, rows = grid.length, cols = grid[0].length;
        int total = rows * cols;
        int[] result = new int[qLen], threshold = new int[total + 1];
        int[][] minReach = new int[rows][cols];

        for (int[] row : minReach) Arrays.fill(row, Integer.MAX_VALUE);
        minReach[0][0] = grid[0][0];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        minHeap.offer(new int[]{0, 0, grid[0][0]});
        int count = 0;

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            threshold[++count] = curr[2];

            for (int[] d : DIRECTIONS) {
                int r = curr[0] + d[0], c = curr[1] + d[1];

                if (r >= 0 && r < rows && c >= 0 && c < cols && minReach[r][c] == Integer.MAX_VALUE) {
                    minReach[r][c] = Math.max(curr[2], grid[r][c]);
                    minHeap.offer(new int[]{r, c, minReach[r][c]});
                }
            }
        }

        for (int i = 0; i < qLen; i++) {
            int left = 0, right = total, val = queries[i];

            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (threshold[mid] < val) left = mid;
                else right = mid - 1;
            }

            result[i] = left;
        }

        return result;
    }
}
