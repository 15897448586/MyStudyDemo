package HuWeiOD;

import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/29 21:51
 */
public class test06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chs = str.toCharArray();
        int n = chs.length, i = 0;
        while (i < n - 1 && chs[i] <= chs[i + 1]) {
            i++;
        }
        if (i == n - 1) {
            System.out.println(str);
            return;
        }
        char min = chs[i + 1];
        int minIndex = i + 1;
        for (int j = i + 2; j < n; j++) {
            if (chs[j] < min) {
                min = chs[j];
                minIndex = j;
            }
        }
        for (int k = 0; k <= i; k++) {
            if (chs[k] > min) {
                chs[minIndex] = chs[k];
                chs[k] = min;
                break;
            }
        }
        System.out.println(String.valueOf(chs));
    }
}
