package TargetOffer;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/5/6 17:50
 */
public class Solution62 {
    public int[] statisticalResult(int[] arrayA) {
        int count0 = 0;
        int[] res = new int[arrayA.length];
        int sum = 1;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] == 0) {
                if (count0 == 1) {
                    return res;
                }
                count0++;
                continue;
            }
            sum *= arrayA[i];
        }
        if (count0 == 0) {
            for (int i = 0; i < arrayA.length; i++) {
                res[i] = sum / arrayA[i];
            }
        } else {
            for (int i = 0; i < arrayA.length; i++) {
                if (arrayA[i] != 0) continue;
                res[i] = sum;
            }
        }
        return res;
    }
}

