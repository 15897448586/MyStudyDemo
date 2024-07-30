package HuWeiOD;

import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/30 14:15
 */
public class test15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int luck = sc.nextInt();
        int m = sc.nextInt();
        if (luck >= m || n < luck) {
            System.out.print(0);
            return;
        }
        int count = 0;
        while (n > 0) {
            int t = n % m;
            if (t == luck) count++;
            n /= m;
        }
        System.out.println(count);
    }
}
