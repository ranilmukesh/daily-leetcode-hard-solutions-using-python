class Solution {
    private static final int MOD = 1_000_000_007;

    private int[][] multiply(int[][] A, int[][] B) {
        int n = A.length, m = B[0].length, common = B.length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; ++i) {
            for (int k = 0; k < common; ++k) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < m; ++j) {
                    res[i][j] = (int)((res[i][j] + 1L * A[i][k] * B[k][j]) % MOD);
                }
            }
        }
        return res;
    }

    private int[][] power(int[][] matrix, int exp) {
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) result = multiply(result, matrix);
            matrix = multiply(matrix, matrix);
            exp >>= 1;
        }
        return result;
    }

    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        int[][] transform = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int shift = 0; shift < nums.get(i); shift++) {
                transform[i][(i + 1 + shift) % 26]++;
            }
        }

        transform = power(transform, t);

        int[][] freq = new int[1][26];
        for (char ch : s.toCharArray()) {
            freq[0][ch - 'a']++;
        }

        freq = multiply(freq, transform);

        int total = 0;
        for (int cnt : freq[0]) {
            total = (total + cnt) % MOD;
        }
        return total;
    }
}
