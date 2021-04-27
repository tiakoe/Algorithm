package 基础题;

import utils.Node;

import java.util.concurrent.ConcurrentHashMap;

public class 练习 {
    //    static int[] arr = new int[] {1, 2, 55, 13, 1, 5, 64, 0, 4};
    static int[] arr = new int[] {11, 12, 5, 0, 422};
    static int[] a2 = new int[] {0, 1, 32, 1, 2, 4, 5, 13, 55, 64};
    static Node root = new Node(a2[0]);

    static void deleteNode(Node node) {
        node.data = node.next.data;
        node.next = node.next.next;
    }

    static Node revertSingle(Node head) {
        // pre 表示最后的结果
        Node pre = null;
        while (head != null) {
            Node t = head.next;
            head.next = pre;
            pre = head;
            head = t;
        }
        return pre;
    }

    static Node findMiddle(Node head) {
        Node fast = head;
        Node slow = head;
        //          while (fast.next!=null&&fast.next.next!=null){  偶数个数，选取第一个
        while (fast != null && fast.next != null) { // 偶数个数，选取第二个
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    static boolean isCycle(Node head) {
        Node fast = head.next;
        Node slow = head;
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        createSingleList();
        root = revertSingle(root);
        System.out.println(findMiddle(root).data);
        printList();

        ConcurrentHashMap<String,String > concurrentHashMap=new ConcurrentHashMap<String,String >();
        concurrentHashMap.put("fdf","fdf");
        concurrentHashMap.get("fdf");
    }

    private static void printList() {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.next;
        }
    }



    private static void createSingleList() {
        Node temp = root;
        for (int i = 1; i < a2.length; i++) {
            temp.next = new Node(a2[i]);
            temp = temp.next;
        }
    }
}
