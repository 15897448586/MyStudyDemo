package TargetOffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * @Author zlx
 * @Date 2024/4/16 11:12
 */
public class Solution1 {

    public int findRepeatDocument(int[] documents) {
        // 首先校验
        if (documents.length == 0) return -1;
        // 1. hashSet
//        Set<Integer> set = new HashSet<>();
//        for (int document : documents) {
//            if (set.contains(document)) {
//                return document;
//            }
//            set.add(document);
//        }
        // 2.排序
//        Arrays.sort(documents);
//        for (int i = 0; i < documents.length - 1; i++) {
//            if (documents[i] == documents[i + 1]) {
//                return documents[i];
//            }
//        }
        // 3. 计数
//        int[] map = new int[documents.length];
//        for (int document : documents) {
//            map[document]++;
//            if (map[document] > 1) {
//                return document;
//            }
//        }
        // 4.原地交换 直接使用索引出的数据，如果相等，证明出现了第二次
        int i = 0;
        while (i < documents.length) {
            if (documents[i] == i) {
                i++;
                continue;
            }
            if (documents[documents[i]] == documents[i]) return documents[i];
            int tmp = documents[i];
            documents[i] = documents[tmp];
            documents[tmp] = tmp;
        }

        return -1;
    }
}
