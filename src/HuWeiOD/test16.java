package HuWeiOD;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/30 14:39
 */
public class test16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Map<Integer, area> map = new HashMap<>();
        for (int i = 0 ; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (!map.containsKey(a)) {
                    map.put(a,new area(i, j));
                }else {
                    area area = map.get(a);
                    area.update(i, j);
                }
            }
        }
        int max = 1;
        for (Integer key : map.keySet()) {
            area area = map.get(key);
            max = Math.max(max, (area.maxX - area.minX + 1) * (area.maxY - area.minY + 1));
        }
        System.out.println(max);
    }
}

class area {
    public int minX = 0;
    public int maxX = 0;

    public int minY = 0;
    public int maxY = 0;

    public area(int x, int y) {
        this.minX = x;
        this.maxX = x;
        this.maxY = y;
        this.minY = y;
    }

    public void update(int x, int y){
        this.minX = Math.min(this.minX, x);
        this.minY = Math.min(this.minY, y);
        this.maxX = Math.max(this.maxX, x);
        this.maxY = Math.max(this.maxY, y);
    }
}
