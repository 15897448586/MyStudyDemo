package HuWeiOD;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author zlx
 * @Date 2024/7/29 23:01
 */
public class test07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            char[] chs = sc.nextLine().toCharArray();
            int n = chs.length;
            int number = 0;
            char sign = '$';
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                char c = chs[i];
                if (Character.isDigit(c)) {
                    number = number * 10 + c - '0';
                }
                if (!Character.isDigit(c) || i == n - 1) {
                    if (sign == '#') {
                        dq.addLast(dq.removeLast() * 4 + 3 * number + 2);
                    } else if (sign == '$') {
                        dq.addLast(number);
                    }
                    sign = c;
                    number = 0;
                }
            }
            int sum = 0;
            if (!dq.isEmpty()) {
                sum = dq.removeFirst();
                while (!dq.isEmpty()) {
                    sum = sum * 2 + dq.removeFirst() + 3;
                }
            }
            System.out.println(sum);
        }
    }
}
