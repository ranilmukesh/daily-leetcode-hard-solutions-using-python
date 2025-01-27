class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        int n = prerequisites.length, m = queries.length;
        if(n == 0){
            List<Boolean> res = new ArrayList<>(m);
            for(int i=0; i<m; i++) res.add(false);
            return res;a
        }
        List<Integer> graph[] = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) graph[i] = new ArrayList<>();
        for(int p[] : prerequisites){
            graph[p[0]].add(p[1]);
        }
        boolean isReachable[][] = new boolean[numCourses][numCourses];
        for(int i=0; i<numCourses; i++){ 
            if(!isReachable[i][i]){ // every node la dfs pandrom***
                dfs(i, graph, isReachable);
            }
        }
        List<Boolean> res = new ArrayList<>(m);
        for(int q[] : queries){
            res.add(isReachable[q[0]][q[1]]);
        }
        return res;
    }
    private void dfs(int curr, List<Integer> graph[], boolean isReachable[][]){
        isReachable[curr][curr] = true;
        for(int neigbor : graph[curr]){
            if(!isReachable[curr][neigbor]){
                isReachable[curr][neigbor] = true;
                dfs(neigbor, graph, isReachable);
                for(int i=0; i<isReachable.length; i++){
                    isReachable[curr][i] |= isReachable[neigbor][i]; 
                }
            }
        }
    }
}
