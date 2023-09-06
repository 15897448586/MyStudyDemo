package Sort;

public abstract class Sort {
    public void sort(int[] arr) {
        if(arr.length < 2) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int i, int j) {

    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
