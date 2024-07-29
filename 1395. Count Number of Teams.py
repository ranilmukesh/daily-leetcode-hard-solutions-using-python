class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for (int i=1; i<rating.length - 1; i++) {
            int[] less = new int[2], greater = new int[2];
            for (int j = 0; j<i; j++) {
                if(rating[j] < rating[i]) {
                    less[0]++;

                }else {
                    greater[0]++;
                }
            }
            for(int k = i+1; k<rating.length; k++) {
                if(rating[i] < rating[k]) {
                    less[1]++;

                }else{
                    greater[1]++;
                }
            }
            res += less[0] * less[1] + greater[0] * greater[1];
                    }
                    return res;
        
    }
}
