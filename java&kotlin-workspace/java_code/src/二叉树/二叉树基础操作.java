package 二叉树;

import utils.Node;

import java.util.*;

public class 二叉树基础操作 {
    static int[] arr = new int[] {11, 12, 5, 0, 422};
    static int[] a2 = new int[] {0, 1,32, 1, 2, 4, 5, 13, 55, 64};

    static void dfsSearch(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    static void dfs(Node node, List<List<Integer>> res, int height) {
        if (node == null) {
            return;
        }
        if (height == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(node.data);
        dfs(node.left, res, height + 1);
        dfs(node.right, res, height + 1);
    }

    static void bfsSearch(Node tree){
        List<List<Integer>> res= bfs(tree);
        for (List<Integer> re : res) {
            System.out.println(Arrays.toString(re.toArray()));
        }
    }

    static List<List<Integer>> bfs(Node root){
        List<List<Integer>>res=new ArrayList<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer>list=new ArrayList<>();
            int size=queue.size();
            for(int i=0;i<size;i++){
                Node node= queue.poll();
                assert node != null;
                list.add(node.data);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    static Node createTree(int[] a) {
        Node root = new Node(a[0]);
        for (int i = 1; i < a.length; i++) {
            insert(root, a[i]);
        }
        return root;
    }

    static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data <= node.data) {
            node.left= insert(node.left, data);
        } else {
            node.right= insert(node.right, data);
        }
        return node;
    }

    static void printTree(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        printTree(node.left);
        printTree(node.right);
    }

    static void invert(Node node){
        if( node==null){
            return;
        }
        Node temp=node.left;
        node.left=node.right;
        node.right=temp;
        invert(node.left);
        invert(node.right);
    }

    static int searchMax(Node node){
        if(node==null){
            return Integer.MIN_VALUE;
        }
        int left=searchMax(node.left);
        int right= searchMax(node.right);
        return Math.max(node.data,Math.max(left,right));
    }

    static int maxDeep(Node node){
        if(node==null){
            return 0;
        }
        int left=maxDeep(node.left);
        int right=maxDeep(node.right);
        return Math.max(left,right)+1;
    }

    static boolean isBalance(Node node){
         return balance(node)!=-1;
    }

    static int balance(Node node){
        if(node==null){
            return 0;
        }
        int left=balance(node.left);
        int right=balance(node.right);
        if(left==-1||right==-1||Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {

        Node tree = createTree(a2);
        printTree(tree);
        dfsSearch(tree);
        bfsSearch(tree);
        invert(tree);
        bfsSearch(tree);
        System.out.println(searchMax(tree));
        System.out.println(maxDeep(tree));
        System.out.println(isBalance(tree));
        //        System.out.println(Arrays.toString(qsort(arr, 0, arr.length - 1)));
    }
}
