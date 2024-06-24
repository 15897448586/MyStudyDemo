package CodeBrainstorming.GraphTheory;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/6/21 21:42
 */
public class Solution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n ;i++) {
            int[] edges = graph[i];
            for (int node : edges) {
                map.computeIfAbsent(node, x -> new ArrayList<>());
                map.get(node).add(i);
                inDegree[i]++;
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            if (!map.containsKey(cur)) continue;
            for (Integer next : map.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{},{0,2,3,4},{3},{4},{}};
        new Solution802().eventualSafeNodes(graph);
    }
}
