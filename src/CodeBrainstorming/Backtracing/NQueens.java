package CodeBrainstorming.Backtracing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/6/7 14:50
 */
public class NQueens {
    private List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) return ans;
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtracking(board, 0, n);
        return ans;
    }

    private void backtracking(char[][] board, int row, int n) {
        if (row == n) {
            ans.add(convert2Sring(board));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(board, row, i, n)) {
                board[row][i] = 'Q';
                backtracking(board, row + 1, n);
                board[row][i] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col, int n) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // 检查45°
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0 ; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    private List<String> convert2Sring(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] chars : board) {
            res.add(String.valueOf(chars));
        }
        return res;
    }
}
