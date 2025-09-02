class Solution {
    public int numberOfPairs(int[][] points) {
        int ans = 0;
        PriorityQueue<int[]> p = new PriorityQueue<>((a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        }); 
        for(int[] point: points){
            p.offer(point);
        }
        for(int i=0;i<points.length;i++){
            points[i] = p.poll();
        }
        int taller = -1;
        for(int i=0;i<points.length-1;i++){
            taller = -1;
            for(int j=i+1;j<points.length;j++){
                if(taller < points[j][1] && points[i][1] >= points[j][1]){
                    ans++;
                    taller = points[j][1];
                }
            }
        }    
        return ans;
    }
}
