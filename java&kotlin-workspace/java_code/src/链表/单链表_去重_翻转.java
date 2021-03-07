package 链表;

import utils.Node;

public class 单链表_去重_翻转 {

    static void pri(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

//    翻转
    static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    //    单链表邻近去重
    static Node removeDul(Node head) {
        Node cur = head, pre = head;
        while (cur != null && cur.next != null) {
            if (cur.next.data != pre.data) {
                cur = cur.next;
                pre = cur;
            } else {
                cur.next = cur.next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, 3, 12, 6, 6, 8, 9};
        Node head = new Node(a[0]);
        Node cur = head;
        for (int i = 1; i < a.length; i++) {
            cur.next = new Node(a[i]);
            cur = cur.next;
        }
        head = reverse(head);
        pri(head);

        pri(removeDul(head));
    }
}
