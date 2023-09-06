package Interface;

public class ArrayQueue<T> implements  Queue<T>{

    private Integer head;
    private Integer tail;
    private Integer capacity;
    private  Object[] elements;

    public ArrayQueue() {
        this.capacity = 16;
        elements = new Object[capacity];
        head = 0;
        tail = 0;
    }

    public ArrayQueue(int capacity) {
        if(capacity == 0) {
            capacity = 16;
        }
        this.capacity = capacity;
        elements = new Object[capacity];
        head = 0;
        tail = 0;
    }


    @Override
    public void enqueue(T t) throws Exception {
        if (tail - head == capacity ) {
            throw new Exception("队列已满");
        }
        if(tail.equals(capacity)) {
            for (int i = head;i < capacity;i++) {
                elements[i - head] = elements[i];
            }
            tail -= head;
            head = 0;
        }
        elements[tail ++] =t;
    }

    @Override
    public T dequeue() {
        if (head == 0) {
            return null;
        }
        return (T)elements[head++];
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public boolean isNull() {
        return head.equals(tail);
    }
}
