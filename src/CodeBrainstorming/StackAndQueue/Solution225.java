package CodeBrainstorming.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Author zlx
 * @Date 2024/5/24 12:01
 */
public class Solution225 {
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new ArrayDeque<>();
            q2 = new ArrayDeque<>();
        }

        public void push(int x) {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            Queue temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }
}
