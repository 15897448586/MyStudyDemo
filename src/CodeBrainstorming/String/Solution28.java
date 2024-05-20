package CodeBrainstorming.String;

/**
 * @Author zlx
 * @Date 2024/5/20 16:24
 */
public class Solution28 {
    public int strStr01(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        if (m < n) return -1;
        int j = 0;
        char[] chm = haystack.toCharArray();
        char[] chn = needle.toCharArray();
        for (int i = 0; i < m; i++) {
            if (chm[i] == chn[0]) {
                int k = 0;
                for (; k < Math.min(n, m - i); k++) {
                    if (chm[i + k] != chn[k]) {
                        break;
                    }
                }
                if (k == n) return i;
            }
        }
        return -1;
    }

    // 构建next数组

//    public int[] computeNext(String pattern) {
//        int[] next = new int[pattern.length()];
//        int i = 0, j = -1;
//        // 初始化next数组的第一个元素为-1,表示无模式匹配时将字符串向右移动一位
//        next[0] = -1;
//        // 从第二个元素开始遍历模式串
//        while (i < pattern.length() - 1) {
//
//            // 如果j为-1或者当前字符匹配，则继续向后匹配
//            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
//                i++;
//                j++;
//                // 记录当前位置的部分匹配值
//                next[i] = j;
//            }else {
//                // 如果当前字符不匹配，则根据部分匹配表决定j的移动位置
//                j = next[j];
//            }
//        }
//        return next;
//    }
//
//    public int strStr(String haystack, String needle) {
//    }


}
