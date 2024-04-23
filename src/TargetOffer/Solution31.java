package TargetOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zlx
 * @Date 2024/4/23 16:50
 */
public class Solution31 {
    Map<Node, Node> map =  new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        Node copyHead = copyNode(head);
        while (cur != null) {
            Node node = copyNode(cur);
            Node copyNext = copyNode(cur.next);
            node.next = copyNext;
            Node copyRandom = copyNode(cur.random);
            node.random = copyRandom;
            cur = cur.next;
        }
        return copyHead;
    }

    private Node copyNode(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
