class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        int[][] adj = new int[n][];
        int[] count = new int[n];
        for (int[] edge : edges) {
            count[edge[0]]++;
            count[edge[1]]++;
        }

        for (int i = 0; i < n; i++) {
            adj[i] = new int[count[i]];
        }

        count = new int[n]; 
        for (int[] edge : edges) {
            adj[edge[0]][count[edge[0]]++] = edge[1];
            adj[edge[1]][count[edge[1]]++] = edge[0]; 
        }
        
        return dfs(0, -1, adj, values, k)[1];
    }
    
    private int[] dfs(int node, int parent, int[][] adj, int[] values, int k) {
        long sum = values[node];
        int components = 0;
        
        for (int child : adj[node]) {
            if (child != parent) {
                int[] result = dfs(child, node, adj, values, k);
                sum = (sum + result[0]) % k;
                components += result[1];
            }
        }
        
        if (sum % k == 0) {
            components++;
        }
        
        return new int[]{(int)(sum % k), components};
    }
}
