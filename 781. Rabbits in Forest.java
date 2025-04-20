class Solution {
    public int numRabbits(int[] answers) {
        int[] cnt = new int[1001];
        int sum = 0;
        for(int in : answers){
            if(++ cnt[in] == 1){
                sum += in + 1;
            }
            if(cnt[in] == in + 1){
                cnt[in] = 0;
            }
        }
        return sum;
    }
}
