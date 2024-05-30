package CodeBrainstorming.StackAndQueue;

import java.util.Stack;

/**
 * @Author zlx
 * @Date 2024/5/24 12:00
 */
public class Solution232 {
    class MyQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public MyQueue() {
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
}
