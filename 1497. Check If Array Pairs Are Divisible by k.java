class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = ((arr[i] % k) + k) % k;
        }
        Arrays.sort(res);
        for (int j = 0, l = res.length - 1; j < l; j++) {
            if (res[j] == 0) {
                if (res[j] != res[j + 1]) {
                    return false;
                }
                j++;
            } else if ((res[j] + res[l--]) % k != 0) {
                return false;
            }
        }
        return true;
    }
}
