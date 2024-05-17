package CodeBrainstorming.Hash;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/5/17 14:51
 */
public class Solution350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] inter = new int[1001];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            inter[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            if (inter[num] > 0) {
                ans.add(num);
                inter[num]--;
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
