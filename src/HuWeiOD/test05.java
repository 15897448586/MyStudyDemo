package HuWeiOD;

import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/29 21:43
 */
public class test05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] chs = sc.nextLine().toCharArray();
        char[] chl = sc.nextLine().toCharArray();
        int s = 0, l = 0;
        while (s < chs.length && l < chl.length) {
            if (chs[s] == chl[l]) {
                s++;
                l++;
            }else {
                l++;
            }
        }
        if (s == chs.length) {
            System.out.println(l  - 1);
        }else {
            System.out.println(-1);
        }
    }
}
