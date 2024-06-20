package CodeBrainstorming.GraphTheory;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/6/20 17:13
 */
public class Prim {
    private static int[][] graph;
    private static final int maxWeight = 100000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 节点的数量
        int V = sc.nextInt();
        // 边的数量
        int E = sc.nextInt();
        graph = new int[V + 1][ V + 1];
        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph[from][to] = weight;
        }
        int[] minDist = new int[V + 1];
        Arrays.fill(minDist, maxWeight);
        boolean[] inTree = new boolean[V + 1];
        for (int i = 1; i < V; i++) {
            // 1.选距离生成树最近的节点
            int cur = -1;
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j <= V; j++) {
                //  选取最小生成树节点的条件：
                //  （1）不在最小生成树里
                //  （2）距离最小生成树最近的节点
                if (!inTree[j] && minDist[j] < minVal) {
                    minVal = minDist[j];
                    cur = j;
                }
            }
            // 2.将最近的节点加入生成树
            inTree[cur] = true;

            // 3.
            for (int j = 1; j <= V; j++) {
                if (!inTree[j] && graph[cur][j] < minDist[j]) {

                }
            }

        }
    }
}
