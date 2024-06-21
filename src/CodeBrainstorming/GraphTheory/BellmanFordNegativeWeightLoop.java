package CodeBrainstorming.GraphTheory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/6/21 15:13
 */
public class BellmanFordNegativeWeightLoop {
    private static final int DEFAULT_VALUE = Integer.MAX_VALUE;

    static class Edge {
        public int from;
        public int to;
        public int weight;
        public Edge(int from, int to, int weight)
        {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            edges.add(new Edge(from, to, weight));
        }
        Boolean flag = false;

        int start = 1, end = n;
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, DEFAULT_VALUE);
        minDist[start] = 0;
        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                if (i < n) {
                    if (minDist[edge.from] != DEFAULT_VALUE && minDist[edge.to] > minDist[edge.from] + edge.weight) {
                        minDist[edge.to] = minDist[edge.from] + edge.weight;
                    }
                }else {
                    if (minDist[edge.from] != DEFAULT_VALUE && minDist[edge.to] > minDist[edge.from] + edge.weight) {
                        flag = true;
                    }
                }
            }
            System.out.println("第" +i+"次");
            for (int j = 1; j <= n; j++) {
                System.out.printf(minDist[j] + " ");
            }
            System.out.println();
        }
    }
}

