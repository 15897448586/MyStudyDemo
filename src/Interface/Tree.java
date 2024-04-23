package Interface;

import Structure.TreeNode;

import java.util.List;

/**
 * @Author zlx
 * @Date 2024/4/23 14:45
 */
public interface Tree {

    /**
     * 插入
     * @param val
     */
    void insert(int val);

    /**
     * 删除
     * @param val
     */
    void delete(int val);

    /**
     * 查找
     * @param val
     * @return
     */
    boolean search(int val);

    /**
     * 查找最小值
     * @return
     */
    int findMinimum();

    /**
     * 查找最大值
     * @return
     */
    int findMaximum();

    /**
     * 中序遍历
     * @return
     */
    List<Integer> inorderTraversal();

    /**
     * 前序遍历
     * @return
     */
    List<Integer> preorderTraversal();

    /**
     * 后续遍历
     * @return
     */
    List<Integer> postorderTraversal();
}
