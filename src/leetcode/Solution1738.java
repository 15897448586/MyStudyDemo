package leetcode;

import java.util.PriorityQueue;

/**
 * @Author zlx
 * @Date 2024/5/26 14:21
 */
public class Solution1738 {
    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int m = matrix.length, n = matrix[0].length;
        checkPQSize(pq, matrix[0][0], k);
        for (int i = 1; i < n; i++) {
            matrix[0][i] ^= matrix[0][i - 1];
            checkPQSize(pq, matrix[0][i], k);
        }
        for (int i = 1; i < m; i++) {
            matrix[i][0] ^= matrix[i - 1][0];
            checkPQSize(pq, matrix[i][0], k);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] ^= (matrix[i][j - 1] ^ matrix[i - 1][j] ^ matrix[i - 1][j - 1]);
                checkPQSize(pq, matrix[i][j], k);
            }
        }
        return pq.peek();
    }

    private void checkPQSize(PriorityQueue<Integer> pq, int num, int k) {
        pq.offer(num);
        if (pq.size() > k) {
            pq.poll();
        }
    }
}
