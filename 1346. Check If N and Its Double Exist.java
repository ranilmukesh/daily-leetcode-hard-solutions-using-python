class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; ++i) {
            if (set.contains(arr[i])) {
                return true;
            }
            set.add(arr[i] << 1);
            if (arr[i] % 2 == 0) {
                set.add(arr[i] >> 1);
            }
        }
        return false;
    }
}
