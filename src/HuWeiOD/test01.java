package HuWeiOD;

import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/29 18:39
 */
public class test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            int n = str.length();
            int totalO = 0;
            for (int i = 0; i < n; i++) {
                char c = str.charAt(i);
                if (c == 'o') totalO++;
            }
            if (totalO % 2 == 0) {
                System.out.println(n);
            }else {
                str += str;
                char[] chs = str.toCharArray();
                int len = 2 * n;
                int r = n - 1;
                for (; r >= 0; r--) {
                    if (chs[r] == 'o') break;
                }
                // 从0开始最长的长度
                int max = r, cnt = totalO - 1;
                for (int l = 0; r < len; r++) {
                    if (chs[r] == 'o') cnt++;
                    if (cnt >= totalO) {
                        while (l < r && chs[l] != 'o') {
                            l++;
                        }
                        if (l < r) {
                            cnt--;
                            l++;
                        }
                    }
                    while (l + n <= r) {
                        l++;
                    }
                    max = Math.max(max, r - l + 1);
                }
                System.out.println(max);
            }
        }
    }
}
