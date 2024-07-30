package HuWeiOD;

import jdk.nashorn.internal.runtime.regexp.joni.ScanEnvironment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/29 23:58
 */
public class test09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(",");
        int len = Integer.parseInt(sc.nextLine());
        int rem = Integer.parseInt(sc.nextLine());
        List<Integer> list =  new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            list.add(Integer.parseInt(ss[i]));
        }
        int index = 0;
        while (list.size() > rem) {
            index = (index + len + 1) % list.size();
            list.remove(index);
            index--;
        }
        int sum = 0;
        for (int i = 0; i  < rem; i++) {
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
