class Solution {
    public long maxKelements(int[] nums, int k) {
        
        long score=0;
       
         PriorityQueue<Integer> pq=new PriorityQueue<>((a, b) -> b - a);

         for(int num : nums)
            pq.add(num);


        while(k > 0)
        {
            int val = pq.remove();
            score += val;

            pq.offer( (val + 2) / 3 );
            k--;
        }

        
        return score;
    }
}
