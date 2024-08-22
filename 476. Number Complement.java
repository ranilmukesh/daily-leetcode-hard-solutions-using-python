class Solution {
    public int findComplement(int num) {
        long check = 1;
        while (check <= num) {
            check *= 2;
        }
        return (int) check - num - 1;
    }
}
