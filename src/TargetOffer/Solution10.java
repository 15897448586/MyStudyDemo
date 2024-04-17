package TargetOffer;

/**
 * @Author zlx
 * @Date 2024/4/17 18:15
 */
public class Solution10 {
    private int count;
    private boolean[][] visited;

    public int wardrobeFinishing(int m, int n, int cnt) {
        if (cnt == 0) return 1;
        visited = new boolean[m][n];
        backtracking(m, n, cnt, 0, 0);
        return count;
    }

    private void backtracking(int m, int n, int cnt, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n ||visited[i][j]) return;
        if (digit(i) + digit(j) > cnt) return;
        count++;
        visited[i][j] = true;
        backtracking(m, n, cnt, i + 1, j);
        backtracking(m, n, cnt, i, j + 1);
    }

    private int digit(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution10 s = new Solution10();
        s.wardrobeFinishing(16,8,4);
    }
}
