package Sort;

public class SelectSort extends Sort {
    @Override
    public void sort(int[] arr, int i, int j) {
        for (int k = i; k <= j ; k++) {
            int mid = Integer.MAX_VALUE;
            int index = -1;
            for (int l = k; l <= j ; l++) {
                if(arr[l] < mid) {
                    mid = arr[l];
                    index = l;
                }
            }
            swap(arr, k, index);
        }
    }
}
