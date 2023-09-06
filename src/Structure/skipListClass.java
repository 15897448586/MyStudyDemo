package Structure;

import java.util.Random;

public class skipListClass {
    int level = 10;
    class Node{
        int val;
        Node[] ne  = new Node[level];
        public Node(int val) {
            this.val = val;
        }
    }
    Random random = new Random();
    Node he = new Node(-1);
    private void find(int t,Node[] ns) {
        Node cur = he;
        for (int i = level - 1; i >= 0 ; i--) {
            while(cur.ne[i] != null && cur.ne[i].val < t) {
                cur = cur.ne[i];
            }
           ns[i] = cur;
        }
    }

    public skipListClass(){}

    public boolean search( int t) {
        Node[] ns = new Node[level];
        find(t,ns);
        return ns[0].ne[0] != null && ns[0].ne[0].val == t;
    }

    public void add(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = new Node(t);
        for (int i = 0; i < level; i++) {
            node.ne[i] = ns[i].ne[i];
            ns[i].ne[i] = node;
            if(random.nextInt(2) == 0) {break;}
        }
    }

    public boolean erase(int t) {
        Node[] ns = new Node[level];
        find(t, ns);
        Node node = ns[0].ne[0];
        if (node == null || node.val != t) {
            return false;
        }
        for (int i = 0; i < level && ns[i].ne[i] == node; i++) {
            ns[i].ne[i] = ns[i].ne[i].ne[i];
        }
        return true;
    }
}
