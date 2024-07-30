package HuWeiOD;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author zlx
 * @Date 2024/7/30 0:18
 */
public class test10 {

    private static Node head = new Node("/", null);
    private static Node cur = head;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if ("".equals(str)) continue;
            char[] chs = str.toCharArray();
            int n = chs.length, i = 0;
            // 去除前导空格
            while (i < n && chs[i] == ' ') {
                i++;
            }
            char[] curChs = null;
            if (chs[i] == 'm') {
                curChs = new char[]{'m', 'k', 'd', 'i', 'r'};
            }else if (chs[i] == 'c') {
                curChs = new char[]{'c', 'd'};
            } else if (chs[i] == 'p') {
                curChs = new char[]{'p', 'w', 'd'};
            }else{
                continue;
            }
            int j = 0;
            while (j < curChs.length && curChs[j] == chs[i + j]) {
                j++;
            }
            // 指令出错
            if (j < curChs.length) continue;
            i += curChs.length;
            if (i < n && chs[i] != ' ') continue;
            //去除空格，寻找下一个指令
            while (i < n && chs[i] == ' ') i++;
            if (i == n) {
                if (curChs[0] == 'p') {
                    System.out.println(cur.path);
                }
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while (i < n && chs[i] != ' ') {
                if (chs[i] == '/') break;
                sb.append(chs[i]);
                i++;
            }
            while (i < n && chs[i] == ' ') i++;
            if(i < n) continue;
            if (curChs[0] == 'c') {
                if ("..".equals(sb.toString())) {
                    if (cur.val =="/") continue;
                    cur = cur.parent;
                }else {
                    for (Node child : cur.children) {
                        if (sb.toString().equals(child.val)) {
                            cur = child;
                            break;
                        }
                    }
                }
            } else if (chs[0] == 'm') {
                if ("..".equals(sb.toString())) {
                    continue;
                }else {
                    cur.children.add(new Node(sb.toString(), cur));
                }
            }
        }
    }
}

class Node {
    public String val;
    public List<Node> children;

    public Node parent;

    public String path;

    public Node (String val, Node parent) {
        this.val = val;
        this.parent = parent;
        if (this.parent == null) {
            this.path = "/";
        }else {
            this.path = parent.path + this.val + "/";
        }
        this.children = new ArrayList<>();
    }
}
