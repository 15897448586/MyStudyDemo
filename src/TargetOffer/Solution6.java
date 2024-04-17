package TargetOffer;

import java.util.Stack;

/** 用两个栈实现队列
 * @Author zlx
 * @Date 2024/4/16 14:20
 */
public class Solution6 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution6() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        swap();
        return stack2.pop();
    }

    public int peek() {
        swap();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void swap() {
        if (!stack2.isEmpty()) return;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

    }
}
