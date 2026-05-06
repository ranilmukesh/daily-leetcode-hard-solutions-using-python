class Solution {
    int n;
    int m;

    public char[][] rotateTheBox(char[][] boxGrid) {
        this.n = boxGrid.length;
        this.m = boxGrid[0].length;

        for (int i = 0; i < n; i++) {
            int j = m - 1;

            while (j >= 0) {
                int temp = j;
                int c = 0;

                while (temp >= 0 && boxGrid[i][temp] != '*') {
                    if (boxGrid[i][temp] == '#') {
                        c++;
                    }
                    temp--;
                }

                while (j != temp) {
                    if (c != 0) {
                        boxGrid[i][j] = '#';
                        c--;
                    } else if (boxGrid[i][j] == '#') {
                        boxGrid[i][j] = '.';
                    }
                    j--;
                }

                j--;
            }
        }

        return rotate(boxGrid);
    }

    public char[][] rotate(char[][] arr) {
        char[][] n_arr = new char[m][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                n_arr[j][n - i - 1] = arr[i][j];
            }
        }

        return n_arr;
    }
}
