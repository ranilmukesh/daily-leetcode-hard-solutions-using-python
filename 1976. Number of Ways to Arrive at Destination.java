class Solution {
    class Pair{
        int node;
        long dis;
        public Pair(int node,long dis){
            this.node = node;
            this.dis = dis;
        }
    }
    public int countPaths(int n, int[][] roads) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Long.compare( a.dis,b.dis));
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int ele[] : roads){
            adj.get(ele[0]).add(new Pair(ele[1],(long)ele[2]));
            adj.get(ele[1]).add(new Pair(ele[0],(long)ele[2]));
        }
        long d[] = new long[n];
        pq.add(new Pair(0,0));
        Arrays.fill(d,Long.MAX_VALUE/2);
        d[0]=0;
        int ways[] = new int[n];
        ways[0]=1;
        int mod = (int)(1e9 + 7);
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            long dis= p.dis;

            for(Pair ele : adj.get(node)){
                if(dis+ele.dis < d[ele.node]){
                    ways[ele.node] = ways[node];
                    d[ele.node] = dis+ele.dis;
                    pq.add(new Pair(ele.node,dis+ele.dis));
                }
                else if(dis+ele.dis == d[ele.node]){
                    ways[ele.node] = (ways[ele.node]+ways[node])%mod;
                }
            }

        }
        return ways[n-1]%mod;
    }
}
