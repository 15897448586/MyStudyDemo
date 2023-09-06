package Sort;

public class RadixSort extends Sort{
    @Override
    public void sort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return ;
        }
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    public static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count the frequency of each digit at the current position
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Modify the count array to store the cumulative sum
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array in sorted order
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the sorted output array to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}
