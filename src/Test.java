import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/4/18 11:24
 */
public class Test {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[0];
        int[] arr =  new int[100001];
        List<Integer> ans =  new ArrayList<>();
        // 统计数量
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (changed[i] < min) min = changed[i];
            if (changed[i] > max) max = changed[i];
            arr[changed[i]]++;
        }
        // 从小到大遍历
        for(int i = min; i <= max; i++) {
            if (arr[i] == 0) continue;
            if (i == 0 && arr[0] > 0) {
                // 两种情况
                if(arr[0] % 2 == 1) {
                    return new int[0];
                }else{
                    for (int j = 0; j < arr[0] / 2; j++) {
                        ans.add(0);
                    }
                    continue;
                }
            }
            int doubleIndex = i * 2;
            if (doubleIndex > max) return new int[0];
            if (arr[i] < arr[doubleIndex]) return new int[0];
            for (int j = 0; j < arr[i]; j++) {
                ans.add(i);
            }
            arr[doubleIndex] -= arr[i];
            arr[i] = 0;
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Test test = new Test();
        int[] changed = {2,1,2,4,2,4};
        test.findOriginalArray(changed);
    }
}
