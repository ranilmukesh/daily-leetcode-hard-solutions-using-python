import java.util.Arrays;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int sum = 0, validCounter = 0, banIndex = 0;

        for (int i = 1; i <= n; i++) {
            while (banIndex < banned.length && banned[banIndex] < i) {
                banIndex++;
            }
            if (banIndex < banned.length && banned[banIndex] == i) {
                continue;
            }
            
            if (sum + i > maxSum) {
                break;
            }
            sum += i;
            validCounter++;
        }
        return validCounter;
    }
}
