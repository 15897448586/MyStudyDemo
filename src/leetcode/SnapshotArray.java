package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zlx
 * @Date 2024/4/26 11:20
 */
public class SnapshotArray {

    class SnapNode{
        int snap;
        int value;
        SnapNode next;

        public SnapNode(){
            value = 0;
            snap = 0;
        }

        public SnapNode(int snap, int value) {
            this.snap = snap;
            this.value = value;
        }
    }
    SnapNode[] snapshots;
    private int snap;

    public SnapshotArray(int length) {
        snapshots = new SnapNode[length];
        snap = 0;
        for (int i = 0; i < length; i++) {
            snapshots[i] = new SnapNode(snap, 0);
        }
    }

    public void set(int index, int val) {
        SnapNode node = snapshots[index];
        // 首先要找到最后一个
        while(node.next != null) {
            node = node.next;
        }
        if (node.snap != this.snap) {
            node.next = new SnapNode(this.snap, val);
            return;
        }
        node.value = val;
    }

    public int snap() {
        snap++;
        return snap - 1;
    }

    public int get(int index, int snap_id) {
        SnapNode node = snapshots[index];
        while (node.next != null) {
            if (node.next.snap <= snap_id) {
                node = node.next;
            }else{
                break;
            }
        }
        return node.value;
    }

    /**
     * ["SnapshotArray","snap","get","get","set","snap","set","get","set","snap","get","set","set"]
     * 			[[1],[],[0,0],[0,0],[0,2],[],[0,14],[0,1],[0,12],[],[0,0],[0,17],[0,16]]
     * @param args
     */
    public static void main(String[] args) {
        SnapshotArray s = new SnapshotArray(1);
        System.out.println(s.snap());
        System.out.println(s.get(0,0));
        System.out.println(s.get(0,0));
        s.set(0,2);
        s.snap();
        s.set(0,14);
        System.out.println(s.get(0,1));
        s.set(0,12);
        s.snap();
        System.out.println(s.get(0,0));
        s.set(0,17);
        s.set(0,16);
    }
}
