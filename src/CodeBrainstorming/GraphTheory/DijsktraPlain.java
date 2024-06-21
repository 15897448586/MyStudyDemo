package CodeBrainstorming.GraphTheory;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/6/21 10:07
 */
public class DijsktraPlain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 节点
        int n = sc.nextInt();
        // 边
        int m = sc.nextInt();
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int val = sc.nextInt();
            graph.computeIfAbsent(from, x -> new ArrayList<>());
            graph.get(from).add(new int[]{to, val});
        }
        boolean[] visited = new boolean[n + 1];
        int[] minDist = new int[n + 1];
        Arrays.fill(minDist, 100001);
        int start = 1, end = n;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{start, 0});
        minDist[start] = 0;
        while (!pq.isEmpty()) {
            // 弹出权值最小的节点， 选择权值最小的节点
            int[] cur = pq.poll();
            int to = cur[0];
            if (visited[to]) continue;

            // 标记节点
            visited[to] = true;


            if (!graph.containsKey(to)) continue;;
            for (int[] edge : graph.get(to)) {
                if (!visited[edge[0]] && minDist[to] + edge[1] < minDist[edge[0]]) {
                    minDist[edge[0]] = minDist[to] + edge[1];
                    pq.offer(new int[]{edge[0], minDist[edge[0]]});
                }
            }
        }
        if (minDist[end] == 100001) {
            System.out.println(-1);
        }else {
            System.out.println(minDist[end]);
        }
    }
}
