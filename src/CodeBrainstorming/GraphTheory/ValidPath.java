package CodeBrainstorming.GraphTheory;

/**
 * @Author zlx
 * @Date 2024/6/20 10:43
 */
public class ValidPath {
    class UnionFindSet {

        private int[] parent;

        public UnionFindSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        private int find(int u) {
            if (u == parent[u]) return u;
            return parent[u] = find(parent[u]);
        }

        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return;
            parent[v] = u;
        }

        public boolean isConnected(int u, int v) {
            return find(u) == find(v);
        }
    }


    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionFindSet ufs = new UnionFindSet(n);
        for (int[] edge : edges) {
            ufs.join(edge[0], edge[1]);
        }
        return ufs.isConnected(source, destination);
    }

    public static void main(String[] args) {

    }
}
