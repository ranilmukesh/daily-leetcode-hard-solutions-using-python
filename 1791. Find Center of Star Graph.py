class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> nodes = new HashSet<>();
        
        for (int[] edge : edges) {
            if (nodes.contains(edge[0])) {
                return edge[0];
            }

            if (nodes.contains(edge[1])) {
                return edge[1];
            }
            
            nodes.add(edge[0]);
            nodes.add(edge[1]);
        }
        
        return  -1;
    }
}
