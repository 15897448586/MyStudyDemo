package CodeBrainstorming.GraphTheory;

/**
 * @Author zlx
 * @Date 2024/6/21 16:00
 */
public class Floyd {

    public void floyd(int[][] graph, int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
}
