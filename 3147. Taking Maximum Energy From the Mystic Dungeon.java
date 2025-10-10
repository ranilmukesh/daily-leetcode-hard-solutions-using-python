class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length, res = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; --i) {
            if (i <= n - k - 1) energy[i] += energy[i + k];
            res = Math.max(energy[i], res);
        }
        return res;
    }
}
