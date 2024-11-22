class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<Integer, Integer> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int[] i : matrix) {
            int sum = 0;
            for (int j = 0; j < i.length; j++) {
                sum += i[n - j - 1] << j;
            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        int max = 0;
        
        for (int i : map.values()) {
            max = Math.max(max, i);
        }
        int maxValue = (1 << n) - 1;

        for (int i : map.keySet()) {
            int count = 0;
            if (i == 0 || i == maxValue) {
                count += map.get(i);
            }
            max = Math.max(max, count);
        }

        for (int i : map.keySet()) {
            int count = 0;
            if (map.containsKey(Math.abs(maxValue - i))) {
                count = map.get(i) + map.get(Math.abs(maxValue - i));
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
