package Interface;

public interface Queue<T> {
    public void enqueue(T item) throws Exception; //入队
    public T dequeue(); //出队
    public int size(); //统计元素数量
    public boolean isNull(); //是否为空
}