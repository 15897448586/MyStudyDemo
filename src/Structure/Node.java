package Structure;

import java.util.List;

/**
 * @Author zlx
 * @Date 2024/5/31 14:54
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};