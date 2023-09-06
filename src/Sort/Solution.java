package Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,1,5,6,4};
        System.out.println(new Solution().findKthLargest(nums, 5));
    }

    public int findKthLargest(int[] nums, int k) {
        return QS(nums, 0, nums.length - 1, nums.length - k );
    }
    private int QS(int[] nums, int left, int right, int k) {
        if(left >= right) {
            return nums[k];
        }
        int key = nums[right];
        int i = left;
        int j = left;
        for (; j < right; j++) {
            if( nums[j] <= key) {
                if(i != j) {
                    swap(nums,i,j);
                }
                i++;
            }
        }
        swap(nums, i, right);
        if (k >= left && k <= i - 1) {
            return QS(nums, left, i - 1, k);
        }else {
            return QS(nums, i + 1, right, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int minSetSize(int[] arr) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : arr) {
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int[] temp = new int[map.size()];
        int index = 0;
        for (Integer value : map.values()) {
            temp[index++] = value;
        }
        Arrays.sort(temp);
        int sum = 0;
        int count =arr.length;
        while (count > arr.length/2) {
            count -= temp[-- index];
            sum++;
        }
        return sum;
    }

}
