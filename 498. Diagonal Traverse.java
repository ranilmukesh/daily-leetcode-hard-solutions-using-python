class Solution {
    public int[] findDiagonalOrder(final int[][] mat) {
      final int m = mat.length;
      if (m == 1) {
        return mat[0];
      }

      final int n = mat[0].length;
      if (n == 1) {
        final int[] result = new int[m];
        for (int rowIndex = 0; rowIndex < m; ++rowIndex) result[rowIndex] = mat[rowIndex][0];
        return result;
      }

      final int[] result = new int[m * n];
      final int decM = m - 1;
      final int decN = n - 1;
      result[0] = mat[0][0];
      int resultIndex = 1;
      int rowIndex = 0;
      int colIndex = 1;

      for (int diagIndex = 2, diagsCount = m + decN; diagIndex <= diagsCount; ++diagIndex) {
        if ((diagIndex & 1) == 0) { 
          for (;;) {
            result[resultIndex++] = mat[rowIndex][colIndex];
            if (rowIndex == decM) {
              ++colIndex;
              break;
            }
            if (colIndex == 0) {
              ++rowIndex;
              break;
            }
            ++rowIndex;
            --colIndex;
          }
        } else { 
          for (;;) {
            result[resultIndex++] = mat[rowIndex][colIndex];
            if (colIndex == decN) {
              ++rowIndex;
              break;
            }
            if (rowIndex == 0) {
              ++colIndex;
              break;
            }
            --rowIndex;
            ++colIndex;
          }
        }
      }

      return result;
    }
}
