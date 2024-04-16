package TargetOffer;

/**
 * 查找二位数组中的数据，二维数组 从左到右，从上往下递增
 * 比较合适的解决方式：从左下角开始，如果大于目标值，则往上走，如果小于目标值，则往右走
 * 另外的解决方式 二分查找 暴力
 * @Author zlx
 * @Date 2024/4/16 11:32
 */
public class Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        // 1.特殊情况的校验
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        //
//        for (int i = 0; i < m; i++) {
//            int index = binarySearch(matrix[i], target);
//            if (index < n && matrix[i][index] == target) {
//                return true;
//            }
//        }

        int i = 0, j = n - 1;
        while (i < m && j  >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

//    private int binarySearch(int[] arr, int target) {
//        int l = 0,  r = arr.length;
//        while (l < r) {
//            int mid = l + (r - l) / 2;
//            if (arr[mid] <= target) {
//                l = mid + 1;
//            } else {
//                r = mid;
//            }
//        }
//        return l;
//    }
}
