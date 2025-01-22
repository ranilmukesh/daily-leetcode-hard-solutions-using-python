class Solution {
    public int[][] highestPeak(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[][] dp = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    dp[i][j] = 0;
                    queue.add(new int[]{i, j});
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] dir : directions) {
                int x = current[0] + dir[0];
                int y = current[1] + dir[1];
                if (x >= 0 && x < n && y >= 0 && y < m && dp[x][y] == -1) {
                    dp[x][y] = dp[current[0]][current[1]] + 1;
                    queue.add(new int[]{x, y});
                }
            }
        }

        return dp;
    }
}
