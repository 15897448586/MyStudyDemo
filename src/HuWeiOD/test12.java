package HuWeiOD;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/7/30 11:52
 */
public class test12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] ss = sc.nextLine().split(",");
            int n = ss.length;
            int[] arr = new int[n];
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(ss[i]);
                if (map.containsKey(arr[i])) {
                    int[] t = map.get(arr[i]);
                    t[0]++;
                    map.put(arr[i], t);
                }else{
                    map.put(arr[i], new int[]{1, i, arr[i]});
                }
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> {
                if (x[0] == y[0]) {
                    return x[1] - y[1];
                }
                return y[0] - x[0];
            });
            for (int a: map.keySet()) {
                pq.offer(map.get(a));
            }
            while (!pq.isEmpty()) {
                if (pq.size() == 1) {
                    System.out.print(pq.poll()[2]);
                }else {
                    System.out.print(pq.poll()[2] + ",");
                }
            }

        }
    }
}
