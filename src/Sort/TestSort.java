package Sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TestSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr_Bubble = new int[n];
        int[] arr_Insertion = new int[n];
        int[] arr_Select = new int[n];
        int[] arr_Merge = new int[n];
        int[] arr_Quick = new int[n];
        int[] arr_default = new int[n];
        int[] arr_Bucket = new int[n];
        int[] arr_Counting = new int[n];
        int[] arr_Radix = new int[n];
        Random rand = new Random();
        int max = 9999;
        int min = 1000;
        for (int i = n, j = 0; i > 0; i--) {
            int temp = rand.nextInt(max - min + 1) + min;
//            int temp = i;
            arr_Bubble[j] = temp;
            arr_Insertion[j] = temp;
            arr_Select[j] = temp;
            arr_Merge[j] = temp;
            arr_Quick[j] = temp;
            arr_default[j] = temp;
            arr_Bucket[j] = temp;
            arr_Counting[j] = temp;
            arr_Radix[j] = temp;
            j++;
        }
//        System.out.println(Arrays.toString(arr_Bubble));
        System.out.println("--------------------------------");
        long d_start = System.currentTimeMillis();
        Arrays.sort(arr_default);
        long d_end = System.currentTimeMillis();
        System.out.println("jdk:"+(d_end -d_start));
        System.out.println("--------------------------------");
        long start = System.currentTimeMillis();
        Sort mySort = new BubbleSort();
        mySort.sort(arr_Bubble);
        long end = System.currentTimeMillis();
        System.out.println("冒泡:"+(end - start));
        System.out.println("--------------------------------");
        long startInsertion = System.currentTimeMillis();
        Sort SortInsertion = new Insertion_Sort();
        SortInsertion.sort(arr_Insertion);
        long endInsertion = System.currentTimeMillis();
        System.out.println("插入:"+(endInsertion - startInsertion));
        System.out.println("--------------------------------");
        long startSelect = System.currentTimeMillis();
        Sort SortSelect = new SelectSort();
        SortSelect.sort(arr_Select);
        long endSelect = System.currentTimeMillis();
        System.out.println("选择:"+(endSelect - startSelect));
        System.out.println("--------------------------------");
        long startMerge = System.currentTimeMillis();
        Sort SortMerge = new MergeSort();
        SortMerge.sort(arr_Merge);
        long endMerge = System.currentTimeMillis();
        System.out.println("归并"+(endMerge - startMerge));
        System.out.println("--------------------------------");
        long startQuick = System.currentTimeMillis();
        QuickSort SortQuick = new QuickSort();
        SortQuick.quickSort_1(arr_Quick);
        long endQuick= System.currentTimeMillis();
        System.out.println("快排"+(endQuick - startQuick));
        System.out.println("--------------------------------");
        long startBucket = System.currentTimeMillis();
        BucketSort SortBucket = new BucketSort();
        SortBucket.sort(arr_Bucket, arr_Bucket.length/100);
        long endBucket= System.currentTimeMillis();
        System.out.println("桶排序"+(endBucket - startBucket));
//        System.out.println(Arrays.toString(arr_Bucket));
        System.out.println("--------------------------------");
        long startCounting = System.currentTimeMillis();
        CountingSort SortCounting = new CountingSort();
        SortCounting.sort(arr_Counting);
        long endCounting= System.currentTimeMillis();
        System.out.println("计数排序"+(endCounting - startCounting));
//        System.out.println(Arrays.toString(arr_Counting));
        System.out.println("--------------------------------");
        long startRadix = System.currentTimeMillis();
        RadixSort SortRadix = new RadixSort();
        SortRadix.sort(arr_Radix);
        long endRadix= System.currentTimeMillis();
        System.out.println("基数排序"+(endRadix - startRadix));
//        System.out.println(Arrays.toString(arr_Radix));
        System.out.println("--------------------------------");

    }
}
