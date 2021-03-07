package 二叉树;

import utils.Node;

public class 创建二叉树 {

    static Node createTree(int[] a, int index) {
        Node node = null;
        if (index < a.length) {
            node = new Node(a[index]);
            node.left = createTree(a, index * 2 + 1);
            node.right = createTree(a, index * 2 + 2);
        }
        return node;
    }

    static void pre(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            pre(root.left);
            pre(root.right);
        }
    }

    /*
    1
    3                     12
    6        8            9         0
    12 23    25 46        57 85

    */
    public static void main(String[] args) {
        int[] a = new int[] {1, 3, 12, 6, 8, 9, 0, 12, 23, 25, 46, 57, 85};
        pre(createTree(a, 0));
    }
}
