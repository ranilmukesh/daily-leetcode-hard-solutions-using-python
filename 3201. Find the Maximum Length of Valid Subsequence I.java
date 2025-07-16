class Solution {
    public int maximumLength(int[] nums) {
        int[] count = new int[2], end = new int[2];

        for (int num : nums) {
            count[num % 2]++;
            end[num % 2] = end[1 - num % 2] + 1;
        }

        return Math.max(
            Math.max(end[0], end[1]),
            Math.max(count[0], count[1])
        );
    }
}
