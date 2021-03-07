package 二叉树;

import utils.Node;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 二叉搜索树 {
    //    是否有效的二叉搜索树
    private boolean isValidBST(Node node, int minVal, int maxVal) {
        if (node == null) {
            return true;
        }
        if (node.data <= minVal || node.data >= maxVal) {
            return false;
        }
        return isValidBST(node.left, minVal, node.data)
                && isValidBST(node.right, node.data, maxVal);
    }

    //    打印二叉树每层节点;
    private void printTreeBFS(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                linkedList.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(linkedList);
        }
        System.out.println(Arrays.toString(new List[] {res}));
    }

    //    之字形打印二叉树
    private void printTreeBFS_zhi(Node root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> linkedList = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                Node node = queue.poll();
                if (res.size() % 2 == 0) {
                    linkedList.addLast(node.data);
                } else {
                    linkedList.addFirst(node.data);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(linkedList);
        }
        System.out.println(Arrays.toString(new List[] {res}));
    }

    private void dfs(List<List<Integer>> list, Node root, int height) {
        if (root == null) {
            return;
        }
        if (height >= list.size()) {
            list.add(new LinkedList<>());
        }
        List<Integer> temp = list.get(height);
        temp.add(root.data);
        dfs(list, root.left, height + 1);
        dfs(list, root.right, height + 1);
    }

    //    打印二叉树每层节点;
    private void printTreeDFS(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        dfs(list, root, 0);
        System.out.println(Arrays.toString(new List[] {list}));
        return;
    }

    private void createTree(int[] data) {
        Node root = new Node(data[0]);
        for (int i = 0; i < data.length; i++) {}
    }

    //    任意方式创建二叉搜索树
    private Node insertSearchTree(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data) {
            root.left = insertSearchTree(root.left, val);
        } else if (val > root.data) {
            root.right = insertSearchTree(root.right, val);
        }
        return root;
    }

    //    搜索二叉树遍历
    private boolean searchTree(Node root, int val) {
        if (root == null) {
            return false;
        }
        Node temp = root;
        while (temp != null) {
            if (val == temp.data) {
                return true;
            } else if (val < temp.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {}
}
