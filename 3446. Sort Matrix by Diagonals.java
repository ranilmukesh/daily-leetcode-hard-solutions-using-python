class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        for(int i=1;i<n;i++) {
            sortDiagonal(grid, 0, i, true);
        }
        for(int i=0;i<n;i++) {
            sortDiagonal(grid, i, 0, false);
        }
        return grid;
    }

    private static void sortDiagonal(int[][] grid, int i, int j, boolean asc) {
        int len = grid.length-i-j;
        int[] arr = new int[len];
        int k =0;
        while(k<len) {
            arr[k++] = grid[i++][j++];
        }
        Arrays.sort(arr);
        if(!asc) {
            k = 0;
            while(k<len) {
                grid[--i][--j] = arr[k++];
            }
        } else {
            k = len-1;
            while(k>=0) {
                grid[--i][--j] = arr[k--];
            }
        }
    }
}
