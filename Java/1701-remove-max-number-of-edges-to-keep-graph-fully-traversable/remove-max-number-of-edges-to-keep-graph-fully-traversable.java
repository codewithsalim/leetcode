class UnionFind {
    private int[] parent;
    private int[] size;
    private int components;

    public UnionFind(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        components = n;
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]); // Path compression
        }
        return parent[u];
    }

    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);
        if (rootU != rootV) {
            if (size[rootU] < size[rootV]) {
                parent[rootU] = rootV;
                size[rootV] += size[rootU];
            } else {
                parent[rootV] = rootU;
                size[rootU] += size[rootV];
            }
            components--;
            return true;
        }
        return false;
    }

    public int getComponents() {
        return components;
    }
}

public class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);
        int usedEdges = 0;

        // Process type 3 edges first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean usedByAlice = ufAlice.union(edge[1], edge[2]);
                boolean usedByBob = ufBob.union(edge[1], edge[2]);
                if (usedByAlice || usedByBob) {
                    usedEdges++;
                }
            }
        }

        // Process type 1 and type 2 edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (ufAlice.union(edge[1], edge[2])) {
                    usedEdges++;
                }
            } else if (edge[0] == 2) {
                if (ufBob.union(edge[1], edge[2])) {
                    usedEdges++;
                }
            }
        }

        // Check if both Alice and Bob can fully traverse the graph
        if (ufAlice.getComponents() > 1 || ufBob.getComponents() > 1) {
            return -1;
        }

        // Maximum number of edges to remove
        return edges.length - usedEdges;
    }
}
