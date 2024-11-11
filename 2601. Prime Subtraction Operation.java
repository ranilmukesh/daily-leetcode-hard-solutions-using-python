class Solution {
    public boolean primeSubOperation(int[] nums) {
        int ma = getma(nums);
        boolean[] sei = new boolean[ma + 1];
        Arrays.fill(sei, true);
        sei[1] = false;
        for (int i = 2; i <= Math.sqrt(ma + 1); i++) {
            if (sei[i]) {
                for (int j = i * i; j <= ma; j += i) sei[j] = false;
            }
        }
        int cur = 1, i = 0;
        while (i < nums.length) {
            int difference = nums[i] - cur;
            if (difference < 0) return false;
            if (sei[difference] == true || difference == 0) {
                i++;
                cur++;
            } else cur++;
        }
        return true;
    }

    private int getma(int[] nums) {
        int max = -1;
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }
}
