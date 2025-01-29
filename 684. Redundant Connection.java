class Solution {
    HashMap<Integer, ArrayList<Integer>> graph;
    public int[] findRedundantConnection(int[][] edges) {
        graph = new HashMap<>();
        int result[] = new int[2];
        int maxNode = 0;
        for (int i = 0; i < edges.length; i++)
        {
            int src = edges[i][0];
            int dest = edges[i][1];
            maxNode = (int)Math.max(maxNode, Math.max(src, dest));
            addEdge(src, dest, graph);
            addEdge(dest, src, graph);
            boolean visited[] = new boolean[maxNode+1];
            visited[src] = true;
            // System.out.println(graph);
            if (checkCycle(src, dest, graph, visited))
            {
                result[0] = src;
                result[1] = dest;
                break;
            }
        }
        return result;
    }

    private void addEdge(int si, int ei, HashMap<Integer, ArrayList<Integer>> graph)
    {
        ArrayList<Integer> li;
        if (graph.containsKey(si))
        {
            li = graph.get(si);
        }
        else
        {
            li = new ArrayList<Integer>();
        }
        li.add(ei);
        graph.put(si, li);
    }

    private boolean checkCycle(int parent, int node, HashMap<Integer, ArrayList<Integer>> graph, boolean visited[])
    {
        if (visited[node] == true)
            return true;
        visited[node] = true;
        for (Integer i : graph.get(node))
        {
            if (i == parent)
                continue;
            if (checkCycle(node, i, graph, visited))
            {
                visited[node] = false;
                return true;
            }
        }
        visited[node] = false;
        return false;
    }
}
