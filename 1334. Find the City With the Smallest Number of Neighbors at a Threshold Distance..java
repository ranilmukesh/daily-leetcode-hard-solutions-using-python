class Solution {
    void floydWarshall(int dist[][], int V) {

            int i, j, k;
            for (k = 0; k < V; k++) {
                for (i = 0; i < V; i++) {
                    for (j = 0; j < V; j++) {
                        if (dist[i][k] + dist[k][j]
                            < dist[i][j])
                            dist[i][j]
                                = dist[i][k] + dist[k][j];
                    }
                }
            }


    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int result = 0;
        int min = 10000;
        int [][] matrix = new int[n][n]; 
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i ++) 
            Arrays.fill(matrix[i], 100000);
        for (int i = 0; i < edges.length; i ++) {
            int [] edge = edges[i];
            matrix[edge[0]][edge[1]] = edge[2];
            matrix[edge[1]][edge[0]] = edge[2];
        }
        for (int i = 0; i < n; i ++) {
            matrix[i][i] = 0;
        }
        floydWarshall(matrix, n);

        for (int i = 0; i < n; i ++) {
            int currMinCity = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] <= distanceThreshold) 
                    currMinCity ++;
            }

            if (currMinCity <= min) {
                min = Math.min(currMinCity, min);
                result = i;
            }
        }
        return result;
    }
}
