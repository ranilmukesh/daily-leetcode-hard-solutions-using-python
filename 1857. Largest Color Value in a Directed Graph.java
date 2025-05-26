// class Solution {
//     private static final int INF = Integer.MAX_VALUE;
//     public int largestPathValue(String colors, int[][] edges) {
//         int n = colors.length();
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++)
//             adj.add(new ArrayList<>());
//         for (int[] e : edges)
//             adj.get(e[0]).add(e[1]);
            
//         int[][] count = new int[n][26];
//         int[] vis = new int[n];
//         int ans = 0;

//         for (int i = 0; i < n && ans != INF; i++) {
//             ans = Math.max(ans, dfs(i, colors, adj, count, vis));
//         }
//         return ans == INF ? -1 : ans;
//     }

//     private int dfs(int node, String colors,List<List<Integer>> adj,int[][] count,int[] vis) {
//         if (vis[node] == 1)
//             return INF;
//         if (vis[node] == 2) {
//             return count[node][colors.charAt(node) - 'a'];
//         }

//         vis[node] = 1;
//         for (int nxt : adj.get(node)) {
//             int res = dfs(nxt, colors, adj, count, vis);
//             if (res == INF)
//                 return INF;
//             for (int c = 0; c < 26; c++) {
//                 count[node][c] = Math.max(count[node][c], count[nxt][c]);
//             }
//         }
//         int col = colors.charAt(node) - 'a';
//         count[node][col]++;
//         vis[node] = 2;

//         return count[node][col];
//     }
// }


class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        
        char[] cs = colors.toCharArray();
        int n = cs.length;
        List<Integer>[] graph = new List[n];
        for(int i = 0; i < n;i++) 
           graph[i] = new LinkedList<>();

        int[] indegree = new int[n];
        for(int[] edge:edges){
            int u = edge[0], v = edge[1];
            indegree[v]++;
            graph[u].add(v);
        }
        
        int[][] count = new int[n][26]; 
        
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < n;i++){
            if(indegree[i] == 0)
                que.offer(i);
        }
        
        int visited = 0;
        int result = 0;

        while (!que.isEmpty()){
            ++visited;
            int u = que.poll(), color = cs[u] -'a';
            result = Math.max(result, ++count[u][color]);

            for(int v: graph[u]){
                for(int i = 0; i < 26; ++i)
                    count[v][i] = Math.max(count[v][i], count[u][i]);
                
                if(--indegree[v] == 0)
                    que.offer(v);
                
            }
        }
        
        //if visited != n means cycle is there
        return visited == n? result : -1;
    }
}
