class Solution {
    public int[] finalPrices(int[] prices) {
        
        int n = prices.length;

        // Time: O(n^2), Space: O(1)
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(prices[i]>=prices[j]){
        //             prices[i] -= prices[j];
        //             break;
        //         }
        //     }
        // }
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()]>=prices[i]) {
                int index = stack.pop();
                prices[index] = prices[index] - prices[i];
            }
            stack.add(i);
        }
        
        while(!stack.isEmpty()){
            prices[stack.peek()] = prices[stack.pop()];
        }

        return prices;

    }
}
