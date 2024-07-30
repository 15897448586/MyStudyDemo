package HuWeiOD;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author zlx
 * @Date 2024/7/30 15:28
 */
public class test17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            char[] chs = sc.nextLine().toCharArray();
            int n = chs.length;
            // 预处理表达式
            for (int i = 0; i < n; i++) {
                if (!isValid(chs[i]) && !Character.isDigit(chs[i])) {
                    chs[i] = ' ';
                }
            }
            // 去除掉所有不合法的表达式
            int i = n - 1;
            while (i >= 0) {
                // 去除多余的空格或者非法字符串
                while (i >= 0 && (isValid(chs[i]) || chs[i] == ' ')) {
                    if (isValid(chs[i])) chs[i] = ' ';
                    i--;
                }

                // 遍历合法的字符串
                while (i >= 0 && (Character.isDigit(chs[i]) || isValid(chs[i]))) {
                    // 需要验证是否合法, 当遇到两个或以上的字符，直接break;
                    if (i > 0 && isValid(chs[i]) && isValid(chs[i - 1])) {
                        break;
                    }
                    i--;
                }
                if (i > 0 && (chs[i] == '+' || chs[i] == '-')) {
                    i--;
                }
            }
            i = 0;
            int start = -1, max = 0,cur = 0;
            while (i < n) {
                while (i < n && chs[i] == ' ') i++;
                int j = i;
                while (j < n && chs[j] != ' ') j++;
                cur = j - i;
                if (cur > max) {
                    start = i;
                    max = cur;
                }
                i = j;
            }
            if (start == -1) System.out.println(0);
            else System.out.println(calculate(chs, start, max));
        }
    }

    private static long calculate(char[] chs, int start, int len) {
        long number = 0;
        char sign = '+';
        Stack<Long> stack = new Stack<>();
        for (int i = start; i < start + len; i++) {
            char c = chs[i];
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            if (!Character.isDigit(c) || i == start + len - 1) {
                if (sign == '+') {
                    stack.push(number);
                } else if (sign == '-') {
                    stack.push(-number);
                } else if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                sign = c;
                number = 0;
            }
        }
        long sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
    private static boolean isValid(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}
