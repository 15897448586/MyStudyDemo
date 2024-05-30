package CodeBrainstorming.StackAndQueue;

import java.util.Stack;

/**
 * @Author zlx
 * @Date 2024/5/30 13:49
 */
public class Solution20 {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (chars[i] == '}') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
            } else if(chars[i] == ')') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
            } else if(chars[i] == ']') {
                if (stack.isEmpty()) return false;
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
            }
            stack.push(chars[i]);
        }
        return stack.isEmpty();
    }
}
