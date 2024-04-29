package Sort;

/**
 * @Author zlx
 * @Date 2024/4/29 11:34
 */
public class DiagonalSort {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < m; i++) {
            sort(mat, i, 0);
        }
        for (int i = 1; i < n; i++) {
            sort(mat, 0, i);
        }
        return mat;
    }
    private void sort(int[][] mat, int startRow, int startCol) {
        int m = mat.length, n = mat[0].length;
        for (int i = startRow + 1, j = startCol + 1; i < m && j < n; i++, j++) {
            int value = mat[i][j];
            int p = i - 1, q = j - 1;
            for (; p >= startRow && q >= startCol; p--, q--) {
                if (mat[p][q] > value) {
                    mat[p + 1][q + 1] = mat[p][q];
                }else {
                    break;
                }
            }
            mat[p + 1][q + 1] = value;
        }
    }
}
