package TargetOffer;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/5/6 17:50
 */
public class Solution62 {
    public int[] statisticalResult(int[] arrayA) {
        int[] res = new int[arrayA.length];
        int sum = 1;
        for (int i = 0; i < arrayA.length ; i++) {
            sum *= arrayA[i];
        }
        for (int i = 0; i < arrayA.length; i++) {
            res[i] = sum / arrayA[i];
        }
        return res;
    }
}
