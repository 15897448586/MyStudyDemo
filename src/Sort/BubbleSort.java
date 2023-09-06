package Sort;

public class BubbleSort extends Sort{
    @Override
    public void sort(int[] arr) {
        super.sort(arr);
    }

    @Override
    public void sort(int[] arr, int i, int j) {
        for (int k = i; k <= j; k++) {
            boolean flag = true;
            for (int l = i; l < j - k; l++) {
                if(arr[l] > arr[l + 1]) {
                    swap(arr, l,l + 1);
                    flag = false;
                }
            }
            if(flag) {
                return;
            }
        }
    }

    @Override
    public void swap(int[] arr, int i, int j) {
        super.swap(arr, i, j);
    }
}
