package CodeBrainstorming.GraphTheory;

/**
 * @Author zlx
 * @Date 2024/6/20 11:30
 */
public class FindRedundantDirectedConnection {
    class UnionFindSet {
        int[] father;

        public UnionFindSet(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int u) {
            if (u == father[u]) return u;
            return father[u] = find(father[u]);
        }

        public void join(int u, int v) {
            u = find(u);
            v = find(v);
            if (u == v) return;
            father[v] = u;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        UnionFindSet ufs = new UnionFindSet(n + 1);
        int cycle = -1, conflict = -1;
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int node1 = edge[0], node2 = edge[1];
            if (parent[node2] != node2) {
                conflict = i;
            } else {
                parent[node2] = node1;
                if (ufs.find(node2) == ufs.find(node1)) {
                    cycle = i;
                } else {
                    ufs.join(node1, node2);
                }
            }
        }

        if (conflict < 0) {
            return new int[]{edges[cycle][0], edges[cycle][1]};
        } else {
            int[] conflictEdge = edges[conflict];
            if (cycle >= 0) {
                return new int[]{parent[conflictEdge[1]], conflictEdge[1]};
            } else {
                return new int[]{conflictEdge[0], conflictEdge[1]};
            }
        }
    }

    public static void main(String[] args) {
        new FindRedundantDirectedConnection().findRedundantDirectedConnection(new int[][]{{2,1},{3,1},{4,2},{1,4}});
    }
}
