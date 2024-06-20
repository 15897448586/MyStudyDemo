package CodeBrainstorming.Graph.Main1;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/6/19 22:37
 */
public class Main {
    static Map<Integer ,List<Integer>> graph = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.computeIfAbsent(a,x ->  new ArrayList<>());
            graph.get(a).add(b);
        }

        visited = new boolean[N + 1];
        visited[0] = true;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            if (!graph.containsKey(key)) continue;
            for (Integer node : graph.get(key)) {
                if (visited[node]) continue;
                queue.offer(node);
                visited[node] = true;
            }
        }


        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(1);
    }

    private static void dfs(Integer key) {
        if (visited[key]) return;
        visited[key] = true;
        if (!graph.containsKey(key)) return;
        for (Integer node : graph.get(key)) {
            dfs(node);
        }
    }
}
