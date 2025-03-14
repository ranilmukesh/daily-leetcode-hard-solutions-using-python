class Solution {
    public int maximumCandies(int[] candies, long k) {
        long total = 0;
        for (int candy : candies){
            total += candy;
        }
        if (total < k) {
            return 0;
        }
        int min = 1;
        int max = (int) (total / k);
        int answer = 0;
        while (min <= max) {
            int guess = (min + max) / 2;
            long children = 0;
            for (int candy : candies) {
                children += candy / guess;
            }
            if (children >= k) {
                answer = guess;
                min = guess + 1;
            } else {
                max = guess - 1;
            }
        }
        return answer;
    }
}
