class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[][] res = new int[k][k];

        int[] priority = new int[k+1];
        int[][] graph = new int[k+1][k+1];
        for(int[] rc : rowConditions) {
            graph[rc[0]][rc[1]]++;
            priority[rc[1]]++;
        }
        int idx = 0;

        int[] rowIdx = new int[k+1];
        while(idx < k) {
            boolean isCycle = true;
            for(int node = 1; node <= k; node++) {
                if(priority[node] == 0) {
                    isCycle = false;
                    priority[node] = -1;
                    rowIdx[node] = idx;
                    idx++;
                    for(int j = 1; j <= k; j++) {
                        priority[j] -= graph[node][j];
                        graph[node][j] = 0;
                    }
                }
            }
            if(isCycle)
                return new int[0][0];
        }

        priority = new int[k+1];
        graph = new int[k+1][k+1];
        for(int[] cc : colConditions) {
            graph[cc[0]][cc[1]]++;
            priority[cc[1]]++;
        }
        idx = 0;

        while(idx < k) {
            boolean isCycle = true;
            for(int node = 1; node <= k; node++) {
                if(priority[node] == 0) {
                    isCycle = false;
                    priority[node] = -1;
                    res[rowIdx[node]][idx] = node;
                    idx++;
                    for(int j = 1; j <= k; j++) {
                        priority[j] -= graph[node][j];
                        graph[node][j] = 0;
                    }
                }
            }
            if(isCycle)
                return new int[0][0];
        }
        
        return res;
    }
}
