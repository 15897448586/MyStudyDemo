package TargetOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 注意一个点，旋转的时候最后一个交给下一个边
 *
 * @Author zlx
 * @Date 2024/4/23 9:57
 */
public class Solution25 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int rowStart = 0, rowEnd = m - 1, colStart = 0, colEnd = n - 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            colEnd--;

            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    ans.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    ans.add(matrix[i][colStart]);
                }
                colStart++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        Solution25 s = new Solution25();
        List<Integer> list = s.spiralOrder(matrix);
        for (Integer integer : list) {
            System.out.print(integer + ",");
        }
    }
}
