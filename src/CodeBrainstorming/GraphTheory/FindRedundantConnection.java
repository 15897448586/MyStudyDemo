package CodeBrainstorming.GraphTheory;

/**
 * @Author zlx
 * @Date 2024/6/20 10:58
 */
public class FindRedundantConnection {
    class UnionFindSet {
        private int[] parent;
        public UnionFindSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int u) {
            if (parent[u] == u) return u;
            return parent[u] = find(parent[u]);
        }

        private boolean join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return false;
            parent[v] = u;
            return true;
        }

        private boolean isConnected(int u, int v) {
            return find(u) == find(v);
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        UnionFindSet ufs = new UnionFindSet(edges.length);
        for (int[] edge : edges) {
            if (!ufs.join(edge[0], edge[1])) {
                return edge;
            }
        }
        return null;
    }
}
