package 二叉树;

import utils.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 中序遍历_非递归 {
    private void mid(Node root) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            Node node = stack.pop();
            list.add(node.data);
            root=node.right;
        }
        System.out.println(Arrays.toString(new List[] {list}));
    }

    public static void main(String[] args) {}
}
