package Sort;

public class Insertion_Sort extends Sort{
    @Override
    public void sort(int[] arr) {
        super.sort(arr);
    }

    @Override
    public void sort(int[] arr, int i, int j) {
        for (int k = i + 1; k <= j; k++) {
            int value = arr[k];
            int l = k - 1;
            for (; l >= 0 ; l--) {
                if (arr[l] > value) {
                    arr[l + 1] = arr[l];
                }else {
                    break;
                }
            }
            arr[l + 1] = value;
        }
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        super.swap(arr, i, j);
    }
}
