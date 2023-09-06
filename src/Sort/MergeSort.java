package Sort;

import com.sun.scenario.effect.Merge;

public class MergeSort extends Sort {
    @Override
    public void sort(int[] arr) {
        if(arr.length < 2) {
            return;
        }
        int[] helper = new int[arr.length];
        merge_sort(arr, helper, 0, arr.length - 1);
    }

    private void merge_sort(int[] arr, int[] helper, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >> 1;
        merge_sort(arr, helper, start, mid);
        merge_sort(arr, helper, mid + 1, end);
        merge(arr, helper, start, end, mid);
    }

    private void merge(int[] arr, int[] helper, int start, int end, int mid) {
        for (int i = start; i <= end; i++) {
            helper[i] = arr[i];
        }
        int helperLeft = start;
        int helperRight = mid + 1;
        int current = start;
        while (helperLeft <= mid && helperRight <= end) {
            if (helper[helperLeft] <= helper[helperRight]) {
                arr[current] = helper[helperLeft];
                helperLeft++;
            } else {
                arr[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = mid - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            arr[current + i] = helper[helperLeft + i];
        }
        while (helperRight <= end) {
            arr[current] = helper[helperRight];
            current++;
            helperRight++;
        }

        //{0,2,5},{1,3,7}
    }
}
