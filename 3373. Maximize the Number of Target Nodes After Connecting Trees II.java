class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
        var colors2 = getColors(toGraph(edges2));
        int max2 = colors2.size() > 1 ? colors2.stream().mapToInt(Integer::intValue).max().orElse(0) : 0;
        return getColors(toGraph(edges1)).stream().mapToInt(i -> i + max2).toArray();
    }
    
    private List<List<Integer>> toGraph(int[][] edges) {
        var graph = new ArrayList<List<Integer>>();
        for (int i = 0; i <= edges.length; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
    
    private List<Integer> getColors(List<List<Integer>> graph) {
        int[] colors = new int[graph.size()];
        Arrays.fill(colors, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        colors[0] = 0;
        
        while (!queue.isEmpty()) {
            int from = queue.poll();
            for (int to : graph.get(from)) {
                if (colors[to] == -1) {
                    colors[to] = (colors[from] + 1) % 2;
                    queue.offer(to);
                }
            }
        }
        
        int zeroCount = 0;
        for (int color : colors) {
            if (color == 0) zeroCount++;
        }
        int oneCount = graph.size() - zeroCount;
        
        var result = new ArrayList<Integer>();
        for (int color : colors) {
            result.add(color == 0 ? zeroCount : oneCount);
        }
        return result;
    }
}
