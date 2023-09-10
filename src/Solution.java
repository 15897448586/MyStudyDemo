import java.util.*;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        ans[0] = getFirst(nums, target);
        ans[1] = getLast(nums, target);
        return ans;
    }

    private int getFirst(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) >> 1;
            if (nums[mid] >= target) {
                if (nums[mid] == target && (mid == 0 || nums[mid - 1] != nums[mid])){
                    return mid;
                }
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    private int getLast(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) >> 1;
            if (nums[mid] <= target) {
                if (nums[mid] == target && (mid == nums.length - 1 || nums[mid - 1] != nums[mid])){
                    return mid;
                }
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode l1 = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = slow.next;
        slow.next = null;
        ListNode tail = slow;
        ListNode next = null;
        ListNode next2 = null;
        l2 = reverseList(l2);
        while (l2 != null && l1 != null) {
            next = l1.next;
            next2 = l2.next;
            l1.next = l2;
            l2.next = next;
            l2 = next2;
            l1 = l1.next.next;
        }
        return;
    }

//    private ListNode reverseList(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode prev = null;
//        ListNode cur = head;
//        while (cur != null) {
//            ListNode next = cur.next;
//            cur.next = prev;
//            prev = cur;
//            cur = next;
//        }
//        return prev;
//    }

//    public static void main(String[] args) {
//        int[] list = new int[]{1,2,3,4,5,6};
//        ListNode head =new ListNode(list[0]);
//        ListNode cur = head;
//        for (int i=1; i<list.length; i++) {
//            ListNode temp = new ListNode(list[i]);
//            cur.next = temp;
//            cur = cur.next;
//        }
//        Solution ss = new Solution();
//        ss.reorderList(head);
//    }

    private ListNode buildList(int[] list) {
        if (list.length == 0) {
            return null;
        }
        ListNode head = new ListNode(list[0]);
        ListNode cur = head;
        for (int i = 1; i < list.length; i++) {
            ListNode temp = new ListNode(list[i]);
            cur.next = temp;
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution ss = new Solution();
//        int[] arr_1 = new int[]{1};
//        int[] arr_2 = new int[]{9};
//        ListNode l1 = ss.buildList(arr_1);
//        ListNode l2 = ss.buildList(arr_2);
//        ListNode node = ss.addTwoNumbers(l1, l2);
//        System.out.println(node);
//        int[] arr = new int[]{1,2,3,4,5, 6,7,8,9};
//        int left = 2, right = 4;
//        ListNode head = ss.buildList(arr);
//        System.out.println(ss.reverseBetween(head, left, right));
//        int[] arr = new int[]{5, 4, 2, 1};
//        ListNode head = ss.buildList(arr);
//        System.out.println(ss.pairSum(head));
    }

    static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>();
        map.put('a', 1);
        map.put('e', 2);
        map.put('i', 3);
        map.put('o', 4);
        map.put('u', 5);
    }

    public int longestBeautifulSubstring(String word) {
        int i = 0, n = word.length();
        int max = 0;
        while (i < n) {
            int low = i;
            i++;
            int r = map.get(word.charAt(i));
            int l = map.get(word.charAt(i - 1));
            while (i < n && (l == r || r == l + 1)) {
                i++;
            }
            int high = i - 1;
            if (word.charAt(low) == 'a' && word.charAt(high) == 'u') {
                max = Math.max(max, high - low + 1);
            }
        }
        return max;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> temp = new LinkedList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag) {
                    temp.addLast(node.val);
                } else {
                    temp.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            flag = !flag;
            ans.add(temp);
        }
        return ans;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 && newInterval.length == 0) {
            return new int[0][2];
        }
        int[][] res = new int[intervals.length + 1][];
        res[0] = newInterval;
        for (int i = 1; i < res.length; i++) {
            res[i] = intervals[i - 1];
        }
        intervals = res;
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
        List<int[]> ans = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n) {
            int low = i;
            i++;
            int max = intervals[low][1];
            while (i < n && (intervals[i][0] == intervals[i - 1][0] || (intervals[i][0] > intervals[i - 1][0] && intervals[i - 1][1] >= intervals[i][0]))) {
                max = Math.max(max, intervals[i][1]);
                i++;
            }
            int[] temp = new int[]{intervals[low][0], max};
            ans.add(temp);
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        Boolean flag = true;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            if (flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.removeFirst();
                    temp.add(node.val);
                    if (node.left != null) {
                        queue.addLast(node.left);
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.removeLast();
                    temp.add(node.val);
                    if (node.right != null) {
                        queue.addFirst(node.right);
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                    }
                }
            }
            ans.add(temp);
            flag = !flag;
        }
        return ans;
    }

    Deque<Integer> deque;


    public int next() {
        return deque.removeFirst();
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        deque.addLast(root.val);
        dfs(root.right);
    }

    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode l2 = slow;
        ListNode l1 = reverseList1(head, slow);
        int max = -1;
        while (l2 != null) {
            max = Math.max(max, l1.val + l2.val);
            l1 = l1.next;
            l2 = l2.next;
        }
        return max;
    }

    private ListNode reverseList1(ListNode head, ListNode temp) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != temp) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    //第一种 快排

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        int index = 1;
        ListNode newNode = new ListNode(-1);
        ListNode cur = newNode;
        cur.next = head;
        while (index != left) {
            cur = cur.next;
            index++;
        }
        ListNode l1 = cur;
        ListNode l2 = cur.next;
        cur = cur.next;
        ListNode prev = null;
        ListNode next;
        while (index <= right) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            index++;
        }
        l1.next = prev;
        l2.next = cur;
        return newNode.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = reverseList(l1);
        ListNode t2 = reverseList(l2);
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        int diff = 0;
        while (t1 != null && t2 != null) {
            int val = t1.val + t2.val + diff;
            diff = val >= 10 ? 1 : 0;
            temp.next = new ListNode(val % 10);
            temp = temp.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        if (t1 != null) {
            temp.next = t1;
            temp = temp.next;
        } else if (t2 != null) {
            temp.next = t2;
            temp = temp.next;
        }
        while (temp != null) {
            if (t1 == null && t2 == null) {
                break;
            }
            int val = temp.val + diff;
            diff = val >= 10 ? 1 : 0;
            temp.val = val % 10;
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        if (diff > 0) {
            temp.next = new ListNode(1);
        }
        return reverseList(newList.next);
    }

    private ListNode reverseList(ListNode root) {
        if (root == null || root.next == null) {
            return root;
        }
        ListNode pre = null, cur = root;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

//    public static void main(String[] args) {
//        Solution ss = new Solution();
//        String s = "erase*****";
//        System.out.println(ss.removeStars(s));
//    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int j = i;
            char c = s.charAt(i);
            if (c == '*') {
                cnt++;
                continue;
            }
            while (cnt > 0) {
                cnt--;
                i--;
                if (i >= 0 && s.charAt(i) == '*') {
                    break;
                }
            }
            if (j == i) {
                sb.append(c);
            } else {
                i++;
            }
        }
        return sb.reverse().toString();
    }

    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean inBlock = false;
        for (String line :
                source) {
            for (int i = 0; i < line.length(); i++) {
                if (inBlock) {
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlock = false;
                        i++;
                    }
                } else {
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlock = true;
                        i++;
                    } else if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '*') {
                        break;
                    } else {
                        sb.append(sb.charAt(i));
                    }
                }
            }
            if (!inBlock && sb.length() > 0) {
                list.add(sb.toString());
                sb.setLength(0);
            }
        }
        return list;
    }

}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Codec1 {
    int INF = -2000;
    TreeNode emptyNode = new TreeNode(INF);

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            sb.append(node.val + "_");
            if (node != emptyNode) {
                queue.offer(node.left == null ? emptyNode : node.left);
                queue.offer(node.right == null ? emptyNode : node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] ss = data.split("_");
        int n = ss.length;
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        for (int i = 1; i < n; i += 2) {
            TreeNode poll = queue.poll();
            int a = Integer.parseInt(ss[i]);
            int b = Integer.parseInt(ss[i + 1]);
            if (a != INF) {
                poll.left = new TreeNode(a);
                queue.offer(poll.left);
            }
            if (b != INF) {
                poll.right = new TreeNode(b);
                queue.offer(poll.right);
            }
        }
        return root;
    }
}

class Codec {

    private int INF = -2000;
    private TreeNode emptyNode = new TreeNode();

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val + "_");
                queue.offer(node.left == null ? emptyNode : node.left);
                queue.offer(node.right == null ? emptyNode : node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("".equals(data)) return null;
        String[] ss = data.split("_");
        int n = ss.length;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        q.offer(root);
        for (int i = 1; i < n; i += 2) {
            TreeNode node = q.poll();
            int a = Integer.parseInt(ss[i]);
            int b = Integer.parseInt(ss[i + 1]);
            if (a != INF) {
                node.left = new TreeNode(a);
                q.offer(node.left);
            }
            if (b != INF) {
                node.right = new TreeNode(b);
                q.offer(node.right);
            }
        }
        return root;
    }
}

