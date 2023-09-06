package Sort;

import java.util.Stack;

public class QuickSort extends Sort{

    @Override
    public void sort(int[] arr, int i, int j) {
        if( i < j) {
            int partition = partition(arr, i, j);
            sort(arr,i,partition - 1);
            sort(arr,partition +1, j);
        }
    }

    public void quickSort_1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length - 1);

        while (!stack.isEmpty()) {
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(arr, low, high);

            if (pivotIndex - 1 > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }

            if (pivotIndex + 1 < high) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }
//    private int partition(int[] arr, int i, int j) {
//        int left = i;
//        int right = j;
//        int key = i;
//        while (left < right) {
//            while (left < right && arr[right] >= arr[key]) {
//                right --;
//            }
//            while (left < right && arr[left] <= arr[key]) {
//                left ++;
//            }
//            super.swap(arr, left, right);
//        }
//        super.swap(arr,key,left);
//        return left;
//    }

    private int partition(int[] arr, int left, int right) {
        int middle = (left + right) >> 1;
        int key = arr[middle];
        super.swap(arr,middle,right);
        int i = left;
        int j = left;
        for (; j < right; j++) {
            if( arr[j] < key) {
                if(i != j) {
                    super.swap(arr,i,j);
                }
                i++;
            }
        }
        super.swap(arr, i, right);
        return i;
    }

//    private int partition(int[] arr, int left, int right) {
//        // 三数取中法 , 随机数在这里写
//        int middle = (left + right) / 2;
//        int pivot = arr[middle];
//        // 交换到最右边
//        super.swap(arr, middle, right);
//        int i = left;
//        for (int j = left; j < right; j++) {
//            if (arr[j] < pivot) {
//                if (i == j) {
//                    ++i;
//                } else {
//                    int tmp = arr[i];
//                    arr[i++] = arr[j];
//                    arr[j] = tmp;
//                }
//            }
//        }
//        super.swap(arr,i, right);
//        return i;
//    }
}
