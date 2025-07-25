class Solution {
    public int maxSum(int[] nums) {
        boolean[] seen = new boolean[201];
        int sumPos = 0;
        int sumNeg = -100;

        for (int num : nums) {
            int idx = num + 100;
            if (!seen[idx]) {
                seen[idx] = true;
                if (num > 0) {
                    sumPos += num;
                } else if (sumNeg < num) {
                    sumNeg = num;
                }

            }
        }
        return sumPos > 0 ? sumPos : sumNeg;
    }
}
