package HuWeiOD;

import java.util.*;

/**
 * @Author zlx
 * @Date 2024/7/29 23:21
 */
public class test08 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int n = sc.nextInt();
//            Deque<Integer> dq = new ArrayDeque<>();
//            int sum = 0;
//            List<int[]> ans = new ArrayList<>();
//            for (int r = 1; r <= n; r++) {
//                if (sum < n) {
//                    dq.addLast(r);
//                    sum += r;
//                }
//                while (sum > n) {
//                    sum -= dq.removeFirst();
//                }
//                if (sum == n) {
//                    ans.add(new int[]{dq.peekFirst(), dq.peekLast()});
//                    sum -= dq.removeFirst();
//                }
//            }
//            int k = ans.size() - 1;
//            while (k >= 0) {
//                int[] t = ans.get(k);
//                StringBuilder sb = new StringBuilder();
//                sb.append(n + "=");
//                for (int i = t[0]; i <= t[1]; i++) {
//                    if (i == t[1]) {
//                        sb.append(i);
//                    }else{
//                        sb.append(i + "+");
//                    }
//                }
//                System.out.println(sb.toString());
//                k--;
//            }
//            System.out.println("Result:" + ans.size());
//
//        }
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            Deque<Integer> dq = new ArrayDeque<>();
            int sum = 0;
            List<int[]> ans = new ArrayList<>();
            for (int l = 1, r = 1; r <= n; r++) {
                if (sum < n) {
                    sum += r;
                }
                while (sum > n) {
                    sum -= l;
                    l++;
                }
                if (sum == n) {
                    ans.add(new int[]{l, r});
                    sum -= l;
                    l++;
                }
            }
            int k = ans.size() - 1;
            while (k >= 0) {
                int[] t = ans.get(k);
                StringBuilder sb = new StringBuilder();
                sb.append(n + "=");
                for (int i = t[0]; i <= t[1]; i++) {
                    if (i == t[1]) {
                        sb.append(i);
                    }else{
                        sb.append(i + "+");
                    }
                }
                System.out.println(sb.toString());
                k--;
            }
            System.out.println("Result:" + ans.size());

        }
    }
}
