class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        int[] res = new int[query.length];
        int i = 0;
        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            uf.union(u, v, edge[2]);

        }

        for(int[] qy : query) {
            int x = qy[0];
            int y = qy[1];
            if(uf.find(x) != uf.find(y)) {
                res[i++] = -1;
            } else {
                res[i++] = uf.findAnd(x);
            }
        }
        return res;
    }
}

class UnionFind {
    int[] rank;
    int[] parent;
    int n;
    int[] and;
    UnionFind(int len) {
        rank = new int[len];
        parent = new int[len];
        and = new int[len];
        for(int i = 0; i < len; i++) {
            parent[i] = i;
            and[i] = -1;
        }
        n = len;
    }

    int findAnd(int x) {
        //System.out.println(Arrays.toString(parent)+" " +x);
        return and[parent[x]];
    }

    int find(int u) {
        if(u == parent[u]) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    void union(int u, int v, int cost) {
        int x = find(u);
        int y = find(v);


        if(and[x] == -1) {
            and[x] = cost;
        }
        if(and[y] == -1) {
            and[y] = cost;
        }
        
        
        //System.out.println("before -> " + x +" "+y + " " + Arrays.toString(and) + " " + cost);
        if(x == y) {
            //System.out.println("testing equal -> " + x +" "+y);
            and[y] &= cost;
            return;
        }
        
        if(rank[x] < rank[y]) {
            parent[x] = y;
            and[y] = (and[x] & and[y] & cost);
        } else if(rank[x] > rank[y]) {
            parent[y] = x;
            and[x] = (and[x] & and[y] & cost);
        } else {
            parent[x] = y;
            rank[y]++;
            and[y] = (and[x] & and[y] & cost);
        }
        
        //and[y] &= cost;
        //System.out.println("after -> " + x +" "+y + " " + Arrays.toString(and) + " " + cost);
        
    }
}

/**
    1111
    0111

    0110


    0001
    0000

    0111


 */
