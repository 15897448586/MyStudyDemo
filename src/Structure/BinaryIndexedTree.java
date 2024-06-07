package Structure;

/**
 * @Author zlx
 * @Date 2024/6/6 10:00
 */
public class BinaryIndexedTree {
    private int[] tree;

    public BinaryIndexedTree(int n) {
        tree = new int[n + 1];
    }

    public void update(int i, int val) {
        while (i < tree.length) {
            tree[i] += val;
            i += lowBit(i);
        }
    }

    public int get(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= lowBit(i);
        }
        return sum;
    }

    private int lowBit(int x) {
        return x & -x;
    }
}
