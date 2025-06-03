class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = candies.length;
        byte[] visited = new byte[(n >> 3) + 1];
        for (int box : initialBoxes) {
            dfs(containedBoxes, box, keys, status, visited);
        }
        int sum = 0;
        for (int i = 0; i < n; ++i) {
            if (status[i] == 1 && check(visited, i)) sum += candies[i];
        }
        return sum;
    }

    private static void dfs(int[][] adj, int u, int[][] keys, int[] status, byte[] visited) {
        set(visited, u);
        for (int key : keys[u]) {
            if (key == u) continue;
            status[key] = 1;
        }
        for (int v : adj[u]) {
            if (!check(visited, v)) {
                dfs(adj, v, keys, status, visited);
            }
        }
    }

    private static boolean check(byte[] mask, int idx) {
        return get(mask, idx) == 1;
    }

    private static int get(byte[] mask, int idx) {
        int i = idx >> 3, bit = idx & 7;
        return mask[i] >> bit & 1;
    }

    private static void set(byte[] mask, int idx) {
        int i = idx >> 3, bit = idx & 7;
        mask[i] |= (byte) (1 << bit);
    }
}
