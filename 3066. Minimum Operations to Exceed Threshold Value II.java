class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i:nums){
            if(i<k) pq.add(i);
        }

        int count = 0;
        while(!pq.isEmpty()){
            int first = pq.poll();
            count++;

            if(pq.isEmpty()) break;

            int second = pq.poll();
            long operation = 2L * first  + second;

            if(operation < k){
                pq.add((int)operation);
            }
        }
        return count;
    }
} 
