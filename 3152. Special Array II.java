class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int totalNums = nums.length;
        int[] prefix = new int[totalNums];

        for (int i = 1; i < totalNums; i++) {
            prefix[i] = prefix[i-1];
            if ((nums[i] & 1) == (nums[i-1] & 1)) {
                prefix[i]++;
            }
        }

      
        int totalQueries = queries.length;

        boolean[] answer = new boolean[totalQueries];
        for (int i = 0; i < totalQueries; i++) {
            int[] currentQuery = queries[i];
            answer[i] = prefix[currentQuery[0]] == prefix[currentQuery[1]];
        }

        return answer;
    }
}
