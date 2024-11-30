import java.util.*;

public class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, LinkedList<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inOutDeg = new HashMap<>();
        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.computeIfAbsent(start, k -> new LinkedList<>()).add(end);
            inOutDeg.put(start, inOutDeg.getOrDefault(start, 0) + 1);
            inOutDeg.put(end, inOutDeg.getOrDefault(end, 0) - 1);
        }
        int startNode = pairs[0][0];
        for (int node : inOutDeg.keySet()) {
            if (inOutDeg.get(node) == 1) {
                startNode = node;
                break;
            }
        }
        LinkedList<int[]> path = new LinkedList<>();
        dfs(startNode, graph, path);
        return path.toArray(new int[path.size()][]);
    }

    private void dfs(int curr, Map<Integer, LinkedList<Integer>> graph, LinkedList<int[]> path) {
        LinkedList<Integer> neighbors = graph.getOrDefault(curr, new LinkedList<>());
        while (!neighbors.isEmpty()) {
            int next = neighbors.poll();
            dfs(next, graph, path);
            path.addFirst(new int[]{curr, next});
        }
    }
}
