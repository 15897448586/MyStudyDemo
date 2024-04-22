package TargetOffer;

/**
 * 有效数字（按顺序）可以分成以下几个部分：
 * <p>
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 *
 * @Author zlx
 * @Date 2024/4/22 21:22
 */
public class Solution16 {
    public boolean isNumber(String s) {
        //有正负号
        boolean hasSign = false;
        // 有E或e
        boolean hasE = false;
        // 有.
        boolean hasPoint = false;
        //
        boolean hasDigit = false;

        char[] chs = s.toCharArray();
        int n = s.length();
        if (n == 1 && !isDigit(chs[0])) return false;
        for (int i = 0; i < n; i++) {
            char ch = chs[i];
            if (isIllegal(ch)) return false;
            if (isSign(ch)) {
                if (i != 0 && (i >= 1 && !isE(chs[i - 1]))) return false;
                if (hasSign) return false;
                hasSign = true;
            }
            if (isE(ch)) {
                if (i == 0 || i == n - 1) return false;
//                if (i >= 1 && isPoint(chs[i - 1])) return false;
                if (hasE) return false;
                if (!hasDigit) return false;
                hasSign = false;
                hasE = true;
            }
            if (isPoint(ch)) {
                // e在.的前面报错
                if (hasE) return false;
                if (hasPoint) return false;
                hasPoint = true;
            }
            if (isDigit(ch)) {
                hasDigit = true;
            }
        }

        return (hasDigit && isPoint(chs[n - 1])) || isDigit(chs[n - 1]);
    }

    private boolean isDigit(char ch) {
        return Character.isDigit(ch);
    }

    private boolean isSign(char ch) {
        if (ch == '+' || ch == '-') {
            return true;
        }
        return false;
    }

    private boolean isE(char ch) {
        if (ch == 'E' || ch == 'e') {
            return true;
        }
        return false;
    }

    private boolean isPoint(char ch) {
        if (ch == '.') {
            return true;
        }
        return false;
    }

    private boolean isIllegal(char ch) {
        return !isDigit(ch) && !isPoint(ch) && !isE(ch) && !isSign(ch);
    }
    public static void main(String[] args) {

        Solution16 s16 = new Solution16();
        String[] legal = {"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "46.e3","+6e-1", "53.5e93", "-123.456e789"};
        for (int i = 0; i < legal.length; i++) {
            System.out.println(s16.isNumber(legal[i]));
        }
        System.out.println("---------");
        String[] illegal = {"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53", "e", ".e1", "+e3"};
        for (int i = 0; i < illegal.length; i++) {
            System.out.println(s16.isNumber(illegal[i]));
        }
    }
}
