package TargetOffer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @Author zlx
 * @Date 2024/4/23 12:47
 */
public class Solution27 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0, pushIndex = 0, n = pushed.length;
        while (pushIndex < n && popIndex < n) {
            // push
            while (pushIndex < n && pushed[pushIndex] != popped[popIndex]) {
                stack.push(pushed[pushIndex++]);
            }
            // 跳过
            if (pushIndex < n && pushed[pushIndex] == popped[popIndex]) {
                popIndex++;
                pushIndex++;
            }
            while (!stack.isEmpty() && popIndex < n && stack.peek() == popped[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty() && popIndex >= n && pushIndex >= n;
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int n = pushed.length;
        for (int i = 0, j = 0; i < n; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution27 s =  new Solution27();
        int[] pushed = {1,2,3,4,5}, popped = {4,5,3,2,1};
        boolean b = s.validateStackSequences(pushed, popped);
        System.out.println(b);
    }
}
