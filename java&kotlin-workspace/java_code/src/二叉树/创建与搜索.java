package 二叉树;

import utils.Node;

import java.util.Comparator;
import java.util.Stack;
import java.util.TreeMap;

public class 创建与搜索 {
    static Node create(int[] a, int index) {
        Node node = null;
        if (index < a.length) {
            node = new Node(a[index]);
            node.left = create(a, index * 2 + 1);
            node.right = create(a, index * 2 + 2);
        }
        return node;
    }

    TreeMap<Integer, Integer> treeMap =
            new TreeMap<>(
                    new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });

    static void depthSearch(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> myStack = new Stack<>();
        myStack.add(head);
        while (!myStack.isEmpty()) {
            Node node = myStack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                myStack.push(node.right);
            }
            if (node.left != null) {
                myStack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {}
}
