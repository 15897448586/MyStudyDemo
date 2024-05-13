package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author zlx
 * @Date 2024/5/13 10:15
 */
public class Solution3 {
    int[][] arr = {{0,1},{0, -1},{-1, 0},{1, 0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int ans = -1;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        if (queue.isEmpty()) return -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            ans++;
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nextX= poll[0] + arr[i][0];
                    int nextY= poll[1] + arr[i][1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        queue.offer(new int[]{nextX,  nextY});
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)return -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(new Solution3().orangesRotting(grid));
    }
}
