package TargetOffer;

/**
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * @Author zlx
 * @Date 2024/5/7 10:01
 */
public class Solution63 {
    public int myAtoi(String s) {
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 0, sign = 1, length = s.length();
        if (length == 0) return 0;
        while (s.charAt(i) == ' ')
            if (++i == length) return 0;
        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') i++;
        for (int j = i; j < length; j++) {
            if (s.charAt(j) < '0' || s.charAt(j) > '9') break;
            if (res > bndry || res == bndry && s.charAt(j) > '7')
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(j) - '0');
        }
        return sign * res;
    }


//    public int myAtoi(String s) {
//        int n = s.length();
//        if (n == 0) return 0;
//        int start = 0;
//        char[] chs = s.toCharArray();
//        // 标记正负
//        boolean flag = true;
//
//        while (start < n && chs[start] == ' ') {
//            start++;
//        }
//        if (start < n && chs[start] == '-') {
//            flag = false;
//            start++;
//        } else if (start < n && chs[start] == '+') {
//            start++;
//        }
//        //去除前导0
//        while (start < n && chs[start] == '0') start++;
//        // 检验数字
//        int digit = start;
//        while (digit < n && Character.isDigit(chs[digit])) {
//            digit++;
//        }
//        if (digit == start) return 0;
//        long max = Integer.MAX_VALUE;
//        long min = Integer.MIN_VALUE;
//        if (flag) {
//            if (digit - start > 10 || (digit - start == 10 && Long.parseLong(s.substring(start, digit)) > max)) {
//                return (int) max;
//            }
//            return Integer.parseInt(s.substring(start, digit));
//        } else {
//            if (digit - start > 10 || (digit - start == 10 && Long.parseLong("-" + s.substring(start, digit)) < min)) {
//                return (int) min;
//            }
//            return Integer.parseInt("-" + s.substring(start, digit));
//        }
//    }
}
