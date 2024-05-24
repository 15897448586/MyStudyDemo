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

    public static int[] buildNext(String pattern) {
        int[] next = new int[pattern.length()];
        // 将第一个位置初始化为-1
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < pattern.length(); i++) {
            // 回溯到前一个字符的最长相同前后缀位置
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }
            if (pattern.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    // KMP算法主方法
    public int search(String text, String pattern) {
        int[] next = buildNext(pattern);
        int j = -1; // pattern的匹配索引
        for (int i = 0; i < text.length(); i++) {
            // 当text和pattern对应位置字符不匹配时，根据next数组更新pattern的匹配索引j
            while (j >= 0 && text.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }
            // 当text和pattern对应位置字符匹配时，移动pattern的匹配索引j
            if (text.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            // 如果pattern的匹配索引j等于pattern长度，说明找到了匹配
            if (j == pattern.length() - 1) {
                // 返回匹配的起始位置
                return i - j;
            }
        }
        // 没有找到匹配，返回-1
        return -1;
    }
//
//    public int strStr(String haystack, String needle) {
//    }

    public static void main(String[] args) {
//        String text = "ABABABABCABABABABCABABABABC";
//        String pattern = "ABABC";
//        Solution28 kmp = new Solution28();
//        int index = kmp.search(text, pattern);
//        if (index != -1) {
//            System.out.println("Pattern found at index: " + index);
//        } else {
//            System.out.println("Pattern not found.");
//        }

        int[] aabaafs = buildNext("aabaaf");
    }

    public int strStr(String haystack, String needle) {
        int[] next = computeNext(needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return i - j;
            }
        }
        return -1;
    }

    private int[] computeNext(String pattern) {
        int[] next = new int[pattern.length()];
        next[0] = -1;
        int j = -1;
        for (int i = 1; i < pattern.length(); i++) {
            while (j >= 0 && pattern.charAt(i) != pattern.charAt(j + 1)) {
                j = next[j];
            }
            if (pattern.charAt(i) == pattern.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

}
