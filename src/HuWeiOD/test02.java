package HuWeiOD;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/29 20:24
 */
public class test02 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int m = in.nextInt();
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = in.nextInt();
        }
        int n = in.nextInt();
        Arrays.sort(arr);
        List<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        for (int i = 1; i < m; i++) {
            if (arr[i] != arr[i - 1]) {
                ans.add(arr[i]);
            }
        }
        if (n * 2 > ans.size()) {
            System.out.println(-1);
            return;
        }
        int maxN = 0;
        int minN = 0;
        for (int i = 0; i < n; i++) {
            minN += ans.get(i);
        }
        for (int i = m - 1; i >= m - n; i--) {
            maxN += ans.get(i);
        }
        System.out.println(minN + maxN);
    }
}

