package 链表;

import utils.Node;

import java.util.Scanner;

public class 单链表 {

    static Node SingleNode(int[] a) {
        if (a.length < 1) {
            return null;
        }
        Node head = new Node(a[0]);
        Node cur = head;
        for (int i = 1; i < a.length; i++) {
            cur.next = new Node(a[i]);
            cur = cur.next;
        }
        return head;
    }

    //k个为一组逆序
    static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.next;
        }
        //判断节点的数量是否能够凑成一组
        if (temp == null)
            return head;

        Node t2 = temp.next;
        temp.next = null;
        //把当前的组进行逆序
        Node newHead = reverseList(head);
        //把之后的节点进行分组逆序
        Node newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.next = newTemp;

        return newHead;
    }

    //逆序单链表
  private   static Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[17];

        for (int i = 0; i < 17; i++) {
            a[i] = i;
        }
        Node head = SingleNode(a);

        head = reverseList(head);
        head = reverseKGroup(head, 3);
        head = reverseList(head);
        Node node = head;
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
    }
}
