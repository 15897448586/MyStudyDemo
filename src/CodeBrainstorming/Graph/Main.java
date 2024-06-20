package CodeBrainstorming.Graph;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/6/19 20:10
 */
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] graph = new int[N][M];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
//                graph[i][j] = sc.nextInt();
                graph[i][j] = (new Random().nextInt() & 1);
                System.out.printf(graph[i][j] + "\t");
            }
            System.out.println();
        }
        if (1 == 1) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (graph[i][0] == 1) {
                dfs (graph, i, 0);
            }
            if (graph[i][M - 1] == 1) {
                dfs (graph, i, M - 1);
            }
        }
        for (int i = 0; i < M; i++) {
            if (graph[0][i] == 1) {
                dfs (graph, 0, i);
            }
            if (graph[N - 1][i] == 1) {
                dfs (graph, N - 1, i);
            }
        }
        int res = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < M - 1; j++) {
                if (graph[i][j] == 1) {
                    res += dfs(graph, i, j);
                }
            }
        }
        System.out.println(res);

    }

    private static  int dfs(int[][] graph, int i, int j) {
        if (i < 0 || i >= graph.length || j < 0 || j >= graph[0].length || graph[i][j] == 0) {
            return 0;
        }
        graph[i][j] = 0;
        return 1 + dfs(graph, i - 1, j) + dfs(graph, i + 1, j)
                + dfs(graph, i, j - 1) + dfs(graph, i, j + 1);
    }
}
