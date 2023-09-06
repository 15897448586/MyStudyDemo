package Interface;

public class LinkQueue<T> implements Queue<T>{
    private LinkNode head;
    private LinkNode tail;
    private Integer size;
    private Integer capacity;

    public LinkQueue() {}
    public LinkQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }
    @Override
    public void enqueue(T item) throws Exception {
        if (size.equals(capacity)) {
            throw new Exception("队列已满");
        }
        LinkNode newNode = new LinkNode(item);
        if (head == null) {
            head = newNode;
            size++;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
            size++;
        }
    }

    @Override
    public T dequeue() {
        if (head == null) {
            return null;
        }
        LinkNode node = head;
        node.next = null;
        head = head.next;
        size--;
        return (T)node.val;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isNull() {
        return this.size == 0;
    }
}
