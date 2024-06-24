package CodeBrainstorming.GraphTheory;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/6/20 23:23
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[numCourses - 1 - i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{0,2},{1,2},{2,0}};
        new Solution210().findOrder(3, prerequisites);
    }
}
