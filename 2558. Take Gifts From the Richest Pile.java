class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<gifts.length;i++){
            pq.add(gifts[i]);
        }
        for(int i=0;i<k;i++){
            int removed = pq.remove();
            removed = (int)Math.floor((int)Math.sqrt(removed));
            pq.add(removed);
        }
        while(!pq.isEmpty()){
            ans = ans + (long)pq.remove();
        }
        return ans;
    }
}
