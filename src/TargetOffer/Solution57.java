package TargetOffer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author zlx
 * @Date 2024/5/6 16:59
 */
public class Solution57 {
    public boolean checkDynasty(int[] places) {
//        int min = 14;
//        int max = -1;
//        HashSet<Integer> set = new HashSet<>();
//        for (int place : places) {
//            if (place == 0) continue;
//            min = Math.min(min, place);
//            max = Math.max(max, place);
//            if (set.contains(place)) return false;
//            set.add(place);
//        }
//        return min + 5 > max;
        int unknown = 0;
        Arrays.sort(places); // 数组排序
        for(int i = 0; i < 4; i++) {
            if(places[i] == 0) unknown = i + 1;
            else if(places[i] == places[i + 1]) return false;
        }
        return places[4] - places[unknown] < 5;
    }
}
