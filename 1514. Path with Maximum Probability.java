class Solution {
    class Pair{
        int node;
        double probability;
        Pair(int node,double probability){
            this.node = node;
            this.probability = probability;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        int ind = 0;
        for(int[] edge:edges){
            adj.get(edge[0]).add(new Pair(edge[1],succProb[ind]));
            adj.get(edge[1]).add(new Pair(edge[0],succProb[ind]));
            ind++;
        }

        return Diskistras(adj,start_node,end_node,n);
    }

    public double Diskistras(ArrayList<ArrayList<Pair>> adj,int start,int end,int n){
        // heap 
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Double.compare(y.probability,x.probability));

        double[] probabilites = new double[n];
        probabilites[start] = 1d;

        pq.add(new Pair(start,1d));

        while(!pq.isEmpty()){
            Pair pair = pq.poll();

            int  currNode = pair.node;
            double currProbability = pair.probability;

            if(currNode == end){
                return probabilites[currNode];
            }

            for(Pair item : adj.get(currNode)){
                int adjNode = item.node;
                double adjProb = item.probability;
                if( (currProbability*adjProb) > probabilites[adjNode] ){
                    probabilites[adjNode] = currProbability*adjProb;
                    pq.add(new Pair(adjNode,probabilites[adjNode]));
                }
            }
        }
        return  probabilites[end];

    }
}
