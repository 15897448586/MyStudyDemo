package CodeBrainstorming.GraphTheory;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/6/20 22:55
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            int x = prerequisite[0];
            int y = prerequisite[1];
            inDegree[y]++;
            graph.computeIfAbsent(x, i -> new ArrayList<>());
            graph.get(x).add(y);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) queue.offer(i);
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

        return ans.size() == numCourses;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        new Solution207().canFinish(5, prerequisites);
    }
}
