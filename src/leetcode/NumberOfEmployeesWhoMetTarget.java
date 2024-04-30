package leetcode;

import java.util.Arrays;

/**
 * @Author zlx
 * @Date 2024/4/30 9:38
 */
public class NumberOfEmployeesWhoMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int)Arrays.stream(hours).filter(i -> i >= target).count();
    }
}
