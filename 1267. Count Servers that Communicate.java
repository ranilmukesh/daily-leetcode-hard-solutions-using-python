class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int sercount = 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    boolean can = false;
                    for (int k = 0; k < n; k++) {
                        if (grid[r][k] == 1 && k != c) {
                            can = true;
                            break;
                        }
                    }
                    if (!can) {
                        for (int j = 0; j < m; j++) {
                            if (grid[j][c] == 1 && j != r) {
                                can = true;
                                break;
                            }
                        }
                    }
                    if (can)
                        sercount +=1;
                }

            }
        }
        return sercount;
    }
}
