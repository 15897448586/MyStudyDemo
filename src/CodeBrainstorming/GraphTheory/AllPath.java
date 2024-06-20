package CodeBrainstorming.GraphTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/6/19 16:14
 */
public class AllPath {
    /**
     * 【输入示例】
     *
     * 5 5
     * 1 3
     * 3 5
     * 1 2
     * 2 4
     * 4 5
     * 【输出示例】
     *
     * 1 3 5
     * 1 2 4 5
     * @param args
     */
    private static int[][] graph;
    private static List<List<Integer>> ans = new ArrayList<>();
    private static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 使用邻接矩阵
        graph = new int[n][n];

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt() -1;
            int y = sc.nextInt() -1;
            graph[x][y] = 1;
        }

        dfs(0, n - 1);
        ans.forEach(System.out::println);
    }

    private static void dfs(int start, int n) {
        if (start == n) {
            ans.add(new ArrayList<>(list));
        }
        int[] edges = graph[start];
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] == 1) {
                list.add(i);
                dfs(i, n);
                list.remove(list.size() - 1);
            }
        }
    }
}
