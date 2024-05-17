package CodeBrainstorming.Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/5/17 14:41
 */
public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] inter = new boolean[1001];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            inter[nums1[i]] = true;
        }
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            if (inter[num]) {
                ans.add(num);
                inter[num] = false;
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
