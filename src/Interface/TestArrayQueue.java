package Interface;


public class TestArrayQueue {
    public static void main(String[] args) throws Exception {
        Queue<Integer> queue = new ArrayQueue<Integer>(3);
        System.out.println(queue.isNull());
        int[] array = {1,2,3,4};
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.size());
    }
}
