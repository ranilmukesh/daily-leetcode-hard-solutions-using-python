class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans = 0 ;

        int n = customers.length;

        for(int i = 0 ; i < n ; i++){
            if(grumpy[i] == 0){
                ans += customers[i] ;
            }
        }

        int max = 0 ;

        int start = 0  , end = minutes;
        int sum = 0 ;
        for(int i = 0 ; i < minutes ; i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
        }

        max = sum;

        for(int i = minutes ; i < n ; i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
            if(grumpy[start] == 1){
                sum -= customers[start];
            }
            start++;
            max = Math.max(max , sum);
        }

        return max + ans;
    }
}
