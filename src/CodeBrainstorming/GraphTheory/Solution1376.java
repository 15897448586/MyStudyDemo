package CodeBrainstorming.GraphTheory;

import javafx.scene.chart.StackedAreaChart;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/6/22 11:35
 */
public class Solution1376 {

    private static final int DEFAULT_VALUE = 200000;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            int from = manager[i];
            if (from == -1) continue;
            graph.computeIfAbsent(from, x -> new ArrayList<>());
            graph.get(from).add(new int[]{i, informTime[i]});
        }

        boolean[] visited = new boolean[n];
        int[] minDist = new int[n];
        Arrays.fill(minDist,DEFAULT_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.offer(new int[]{headID, informTime[headID]});
        minDist[headID] = informTime[headID];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int from = cur[0];
            if (visited[from]) continue;
            
            visited[from] = true;

            if (!graph.containsKey(from)) continue;
            List<int[]> edges = graph.get(from);
            for (int[] edge : edges) {
                if (!visited[edge[0]] && minDist[from] +  edge[1] < minDist[edge[0]]) {
                    minDist[edge[0]] = minDist[from] +  edge[1];
                    pq.offer(new int[]{edge[0], minDist[edge[0]]});
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (minDist[i] == DEFAULT_VALUE) return -1;
            res =Math.max(res, minDist[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6, headID = 2;
        int[] manager = {2,2,-1,2,2,2}, informTime = {0,0,1,0,0,0};
        new Solution1376().numOfMinutes(n, headID, manager, informTime);
    }
}
