package CodeBrainstorming.BinaryIndexedTree;

/**
 * @Author zlx
 * @Date 2024/6/6 10:25
 */
public class NumArray {

    class BIT{
        private int[] tree;
        public BIT(int n) {
            tree = new int[n + 1];
        }

        private int lowBit(int x) {
            return x & -x;
        }

        public void add(int i, int val) {
            while (i < tree.length) {
                tree[i] += val;
                i += lowBit(i);
            }
        }

        public int getSum(int i) {
            int sum = 0;
            while (i > 0) {
                sum += tree[i];
                i -= lowBit(i);
            }
            return sum;
        }
    }

    private int[] nums;
    private BIT bit;

    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        bit = new BIT(n);
        for (int i = 0; i < n; i++) {
            bit.add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        bit.add(index + 1, val - nums[index]);
    }

    public int sumRange(int left, int right) {
        return bit.getSum(right + 1) -bit.getSum(left);
    }
}

