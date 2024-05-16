package CodeBrainstorming.LinkedList;

/**
 * @Author zlx
 * @Date 2024/5/16 11:52
 */
public class Solution707 {
    class MyLinkedList {
        int size;
        private Node head;
        private Node tail;
        class Node {
            public int val;
            public Node next;
            public Node prev;

            public Node(int val){
                this.val = val;
            }
        }

        public MyLinkedList() {
            size = 0;
            head = new Node(-1 );
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            Node node = find(index);
            return node.val;
        }

        public void addAtHead(int val) {
            Node node = new Node(val);
            Node next =  head.next;
            head.next = node;
            node.next = next;
            next.prev = node;
            node.prev = head;
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node(val);
            Node prev = tail.prev;
            tail.prev = node;
            node.prev = prev;
            prev.next = node;
            node.next = tail;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 ||  index > size) return;
            if (index == size) {
                addAtTail(val);
                return;
            }
            Node node = find(index);
            Node prev = node.prev;
            Node cur =  new Node(val);
            prev.next = cur;
            cur.next = node;
            node.prev = cur;
            cur.prev = prev;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 ||  index >= size) return;
            Node node = find(index);
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
            size--;
        }

        private Node find(int index) {
            Node cur = head.next;
            while (index-- > 0) {
                cur = cur.next;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new Solution707().new MyLinkedList();
        myLinkedList.addAtHead(1);
        myLinkedList.addAtTail(2);
        myLinkedList.addAtIndex(1,2);
        myLinkedList.get(1);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.get(1);
    }
}
