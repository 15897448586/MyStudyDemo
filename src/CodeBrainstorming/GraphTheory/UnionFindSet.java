package CodeBrainstorming.GraphTheory;

/**
 * @Author zlx
 * @Date 2024/6/20 9:59
 */
public class UnionFindSet {
    private int[] parent;
    public UnionFindSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    private int find(int u) {
        if (parent[u] == u) {
            return u;
        }
        return parent[u] = find(parent[u]);
    }

    private void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        parent[v] = u;
    }

    private boolean isConnected(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }
}
