package Sort;

public class CountingSort extends Sort{
    @Override
    public void sort(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int[] counting = new int[max - min + 1];
        for (int i : arr) {
            counting[i - min]++;
        }

        int index = 0;
        for (int i = 0; i < counting.length; i++) {
            while (counting[i] > 0) {
                arr[index++] = min + i;
                counting[i] --;
            }
        }

    }
}
