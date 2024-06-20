package CodeBrainstorming.GraphTheory;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/6/20 22:25
 */
public class TopologicalSort {

    private static int[] inDegree;
    private static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // n个文件
        int n = sc.nextInt();
        // m个规则
        int m = sc.nextInt();

        inDegree = new int[n];
        graph = new HashMap<>();
        Arrays.fill(inDegree, 0);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.computeIfAbsent(x, item -> new ArrayList<>());
            inDegree[y]++;
            graph.get(x).add(y);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int x : inDegree) {
            if (x == 0) {
                queue.offer(x);
            }
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            ans.add(cur);
            if (graph.containsKey(cur)) {
                List<Integer> files = graph.get(cur);
                for (int i = 0; i < files.size(); i++) {
                    Integer next = files.get(i);
                    inDegree[next]--;
                    if (inDegree[next] == 0) queue.offer(next);
                }
            }
        }
        if (ans.size() == n) {
            for (int i = 0; i < n - 1; i++) {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println(ans.get(n - 1));
        }else {
            System.out.println(-1);
        }
    }
}
