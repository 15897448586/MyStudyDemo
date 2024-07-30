package HuWeiOD;

import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/29 21:30
 */
public class test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] ss = str.split(",");
            int n = ss.length;
            int[] arr = new int[n + 2];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = Integer.parseInt(ss[i - 1]);
            }
            int cnt = 0;
            for (int i = 1; i < n + 1; i++) {
                if (arr[i] > arr[i - 1] && arr[i] < arr[i + 1]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
