package CodeBrainstorming.Backtracing;

/**
 * @Author zlx
 * @Date 2024/6/7 15:08
 */
public class Sudoku {
    public void solveSudoku(char[][] board) {
        sudokuHelper(board);
    }

    private boolean sudokuHelper(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 跳过填充过的格子
                if (board[i][j] != '.') continue;
                for (int k = 1; k <= 9; k++) {
                    char c = (char) (k + '0');
                    // 检验在当前情况下是否满足
                    if (isValid(board, i, j, c)) {
                        board[i][j] = c;
                        if (sudokuHelper(board)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        // 检查行
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c) return false;
        }

        // 检查列
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
        }

        // 检查3*3宫格
        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j++) {
                if (board[i][j] == c) return false;
            }
        }

        return true;
    }
}
