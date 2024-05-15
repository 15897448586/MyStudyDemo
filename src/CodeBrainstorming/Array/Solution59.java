package CodeBrainstorming.Array;

/**
 * @Author zlx
 * @Date 2024/5/15 13:48
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] grip = new int[n][n];
        int rowS = 0, rowE = n - 1;
        int colS = 0, colE = n - 1;
        int num = 1;
        while (rowS <= rowE && colS <= colE) {
            for (int i = colS; i <= colE ; i++) {
                grip[rowS][i] = num++;
            }
            rowS++;
            for (int i = rowS; i <= rowE ; i++) {
                grip[i][colE] = num++;
            }
            colE--;
            if (rowS <= rowE) {
                for (int i = colE; i >= colS ; i--) {
                    grip[rowE][i] = num++;
                }
                rowE--;
            }
            if (colS <= colE) {
                for (int i = rowE; i >= rowS ; i--) {
                    grip[i][colS] = num++;
                }
                colS++;
            }
        }
        return grip;
    }
}
