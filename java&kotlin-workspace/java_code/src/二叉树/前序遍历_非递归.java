package 二叉树;

import utils.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 前序遍历_非递归 {
    //    非递归
    private void pre(Node root) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!list.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                list.add(root.data);
                root = root.left;
            }
            while (!stack.isEmpty()) {
                root = stack.pop().right;
            }
        }
        System.out.println(Arrays.toString(new List[] {list}));
    }
    // 更简洁的方式
    private void pre2(Node root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.data);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        System.out.println(Arrays.toString(new List[] {list}));
    }


    public static void main(String[] args) {}
}
