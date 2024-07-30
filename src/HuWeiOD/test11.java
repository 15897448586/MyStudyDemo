package HuWeiOD;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/30 11:35
 */
public class test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(), n = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });
        for (int i = 0; i < n ;i++) {
            int k = sc.nextInt();
            pq.offer(new int[]{Math.abs(k - h), k});
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll()[1] + " ");
        }
    }
}
