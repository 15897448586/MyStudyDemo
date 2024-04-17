import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class StackOfPlates {
    private List<Stack<Integer>> list;
    private Integer cap;
    private Stack<Integer> curStack;
    public StackOfPlates(int cap) {
        this.cap = cap;
        this.list = new ArrayList<>();
        this.curStack = new Stack<Integer>();
        this.list.add(curStack);
    }

    public void push(int val) {
        if (curStack.size() == cap) {
            curStack = new Stack<Integer>();
            list.add(curStack);
        }
        curStack.push(val);
    }

    public int pop() {
        if(curStack.isEmpty()) {
            list.remove(list.size() - 1);
        }
        if (list.isEmpty()) {
            return -1;
        }
        curStack = list.get(list.size() - 1);
        int val =  curStack.pop();
        if (curStack.isEmpty()) {
            list.remove(list.size() - 1);
        }
        return val;
    }

    public int popAt(int index) {
        if(list.size() <= index) {
            return -1;
        }
        Stack<Integer> temp = list.get(index);
        if (temp.isEmpty()) {
            list.remove(index);
            return -1;
        }
        int val =  temp.pop();
        if (temp.isEmpty()) {
            list.remove(index);
        }
        return val;
    }

    public static void main(String[] args) {
        StackOfPlates obj = new StackOfPlates(2);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.popAt(0);
        obj.popAt(0);
        obj.popAt(0);
        System.out.println(obj);
    }
}