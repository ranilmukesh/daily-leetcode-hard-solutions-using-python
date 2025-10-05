class Solution {
    int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
    List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        char[][] markings = new char[heights.length][heights[0].length];
        for (int  col = 0; col < heights[0].length; col++) {
            dfs(heights, 0, col, markings, 'P');
        }

        for (int row = 1; row < heights.length; row++) {
            dfs(heights, row, 0, markings, 'P');
        }

        for (int row = 0; row < heights.length; row++) {
            dfs(heights, row, heights[0].length - 1, markings, 'A');
        }

        for (int col = 0; col < heights[0].length - 1; col++) {
            dfs(heights, heights.length - 1, col, markings, 'A');
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, char[][] markings, char mark) {
        if (!isInBounds(heights, i, j)) {
            return;
        }
        if (markings[i][j] == mark) {
            return;
        }
        if (markings[i][j] == 'P') {
            result.add(Arrays.asList(i, j));
        }
        markings[i][j] = mark;
        for (int[] dir : dirs) {
            int k = i + dir[0];
            int l = j + dir[1];
            if (isInBounds(heights, k, l) && heights[k][l] >= heights[i][j]) {
                dfs(heights, k, l, markings, mark);
            }
        }
    }

    private boolean isInBounds(int[][] heights, int i, int j) {
        return i < heights.length && i >= 0 && j < heights[0].length && j >= 0;
    }
}
