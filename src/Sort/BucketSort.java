package Sort;

import java.util.Arrays;

public class BucketSort extends Sort {
    public void sort(int[] arr, int count) {
        if (arr.length < 2) {
            return ;
        }
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            max = Math.max(max,i);
            min = Math.min(min,i);
        }
        if (max == min) {
            return ;
        }
        int size = (max - min) / count + 1;
        int[][] buckets = new int[count][size];
        int[] bucketIndex = new int[count];
        for (int i = 0; i < arr.length; i++) {
            int o_idx = (arr[i] - min)/size;
            int i_idx = bucketIndex[o_idx];
            if (i_idx == buckets[o_idx].length) {
                buckets[o_idx] = copy_double_array(buckets[o_idx]);
            }
            buckets[o_idx][bucketIndex[o_idx]++] = arr[i];
        }
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            int[] bucket = buckets[i];
            sort(bucket,0,bucketIndex[i] - 1);
            for (int j = 0; j < bucketIndex[i]; j++) {
                arr[index++] = buckets[i][j];
            }
        }
    }

    private int[] copy_double_array (int[] arr) {
        int[] temp = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i];
        }
        return temp;
    }
    public void sort(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }
        int patition = patition(arr, i, j);
        sort(arr, i, patition - 1);
        sort(arr, patition + 1, j);
    }

    private int patition(int[] arr, int left, int right) {
        int mid = (left + right) >> 1;
        int key = arr[mid];
        super.swap(arr, mid, right);
        int i = left;
        int j = left;
        for (;j < right; j++) {
            if (arr[j] < key) {
                if (i != j) {
                    super.swap(arr, i, j);
                }
                i++;
            }
        }
        super.swap(arr, i, right);
        return i;
    }
}
