package HuWeiOD;

import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/30 13:03
 * 给定一段“密文”字符串 s，其中字符都是经过“密码本”映射的，现需要将“密文”解密并输出。
 *
 * 映射的规则（'a' ~ 'i'）分别用（'1' ~ '9'）表示；（'j' ~ 'z'）分别用（"10*" ~ "26*"）表示。
 *
 * 约束：映射始终唯一。
 */
public class test13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            char[] chs = sc.nextLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            int n = chs.length;
            for (int i = n - 1; i >= 0; i--) {
                int number = 0;
                if (chs[i] == '*') {
                    number = (chs[i - 2] - '0') * 10 + chs[i - 1] - '0';
                    i -= 2;
                }else{
                    number = chs[i] - '0';
                }
                sb.append((char) (number  -  1 + 'a'));
            }
            System.out.print(sb.reverse().toString());
        }
    }
}
