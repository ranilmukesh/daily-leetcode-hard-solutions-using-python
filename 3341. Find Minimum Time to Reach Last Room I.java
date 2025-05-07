class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.offer(new int[]{0, 0, 0});
        
        Set<Integer> visited = new HashSet<>();
        int cols = moveTime[0].length;
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int i = p[0];
            int j = p[1];
            int c = p[2];
            if (visited.contains(i*cols+j)) continue;
            if (i == moveTime.length-1 && j == moveTime[0].length-1) {
                return c;
            }
            visited.add(i*cols+j);
            if (i+1 < moveTime.length && !visited.contains((i+1)*cols+j)) {
                pq.offer(new int[]{i+1, j, Math.max(c, moveTime[i+1][j])+1});
            }
            if (j+1 < cols && !visited.contains(i*cols+j+1)) {
                pq.offer(new int[]{i, j+1, Math.max(c, moveTime[i][j+1])+1});
            }
            if (i > 0 && !visited.contains((i-1)*cols+j)) {
                pq.offer(new int[]{i-1, j, Math.max(c, moveTime[i-1][j])+1});
            }
            if (j > 0 && !visited.contains(i*cols+j-1)) {
                pq.offer(new int[]{i, j-1, Math.max(c, moveTime[i][j-1])+1});
            }
        }
        return -1;
    }
}
