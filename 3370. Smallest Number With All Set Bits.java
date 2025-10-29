class Solution {
    public int smallestNumber(int n) {
        if (n == 0) return 1;
        return n | smallestNumber(n >> 1);
    }
}
