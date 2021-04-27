package 二叉树;

import utils.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class 后序遍历_非递归 {

    private void last(Node root) {
        List<Integer> list = new LinkedList<>();
        Stack<Node> stack = new Stack();
        if (root == null) {
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(0, root.data);
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }
    }

    public static void main(String[] args) {}
}
