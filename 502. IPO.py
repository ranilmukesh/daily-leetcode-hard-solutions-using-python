class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int profit = w;
        int[][] arr = new int[profits.length][2];
        int addedIndex = 0;
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for(int i=0;i<capital.length;i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));


        for(int i=0;i<k;i++) {
            while(addedIndex < arr.length && arr[addedIndex][0] <= profit) {
                maxHeap.add(arr[addedIndex++]);
            }
            if(maxHeap.size() == 0) {
                return profit;
            }
            int[] temp = maxHeap.poll();
            profit += temp[1];
        }
        return profit;
    }
}
