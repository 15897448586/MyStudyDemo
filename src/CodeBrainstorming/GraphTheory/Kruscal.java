package CodeBrainstorming.GraphTheory;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/6/20 20:06
 */
public class Kruscal {

    private static edge[] edges;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        edges = new edge[E];
        int res = 0;
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges[i] = new edge(from, to, weight);
        }
        List<edge> list = new ArrayList<>();
        Arrays.sort(edges, (x, y) -> x.weight - y.weight);
        UnionFind ufs = new UnionFind(V + 1);
        for (edge edge : edges) {
            int from = ufs.find(edge.from);
            int to = ufs.find(edge.to);
            if (from != to) {
                res += edge.weight;
                ufs.join(from, to);
                list.add(edge);
            }
        }
        System.out.println(res);
//        for (edge edge : list) {
//            System.out.println(edge.toString());
//        }
    }
}

class UnionFind {

    private int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int u) {
        if (u == parent[u]) {
            return u;
        }
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

class edge{
    public int from;
    public int to;
    public int weight;

    public edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public String toString() {
        return this.from + " -> " + this.to;
    }
}