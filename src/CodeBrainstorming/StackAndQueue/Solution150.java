package CodeBrainstorming.StackAndQueue;

import java.util.Stack;

/**
 * @Author zlx
 * @Date 2024/5/30 14:16
 */
public class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n = tokens.length;
        for (String token : tokens) {
            if (check(token)) {
                int sec = stack.pop();
                int fir = stack.pop();
                stack.push(calculate(fir,  sec, token));
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private boolean check(String token) {
        return "+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token);
    }

    private int calculate(int first, int second, String symbol) {
        switch (symbol) {
            case "+":
                return  first + second;
            case "-":
                return  first - second;
            case "*":
                return  first * second;
            case "/":
                return  first / second;
            default:
                return 0;
        }
    }



}
