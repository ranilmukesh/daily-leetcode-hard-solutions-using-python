class Solution {
   static public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = times.length, k = times[targetFriend][0];
        for (int i = 0; i < n; i++) pq.add(i);
        int[] arrival = new int[100001];
        for (int i = 0; i < n; i++) arrival[times[i][0]] = times[i][1];
        ArrayList<Integer>[] seatBooked = new ArrayList[100001];
        for (int i = 0; i < arrival.length; i++) {
            if (seatBooked[i] != null)
                for (int j = 0; j < seatBooked[i].size(); j++) 
                    pq.add(seatBooked[i].get(j));

            if (arrival[i] > 0) {
                int minimumSeat = pq.poll();
                if (seatBooked[arrival[i]] == null) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(minimumSeat);
                    seatBooked[arrival[i]] = l;
                } else 
                    seatBooked[arrival[i]].add(minimumSeat);
                if (i == k) return minimumSeat;
            }
        }
        return 0;
    }
}
